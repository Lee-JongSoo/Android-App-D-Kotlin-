package com.example.project1

import android.Manifest.*
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import com.google.api.services.vision.v1.Vision
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_analyze_view.*
import java.io.File
import java.lang.Exception
import java.lang.StringBuilder
import java.lang.ref.WeakReference
import java.net.CacheResponse
import java.util.*

class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST = 1000
    private val GALLERY_PERMISSION_REQUEST = 1001
    private val FILE_NAME = "picture.jpg"
    private var uploadChooser: UploadChooser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListener()
    }

    private fun setupListener() {
        upload_image.setOnClickListener {
            uploadChooser = UploadChooser().apply {
                addNotifier(object : UploadChooser.UploadChooserNotifierInterface {
                    override fun cameraOnClick() {
                        Log.d("upload", "cameraOnClick")
                        checkCameraPermission()
                    }

                    override fun galleryOnClick() {
                        Log.d("upload", "galleryOnClick")
                        checkGalleryPermission()
                    }
                })
            }
            uploadChooser!!.show(supportFragmentManager, "")
        }
    }

    private fun checkCameraPermission() {
        if (PermissionUtil().requestPermission(
                this,
                CAMERA_PERMISSION_REQUEST,
                permission.CAMERA,
                permission.READ_EXTERNAL_STORAGE
            )
        ) openCamera()
    }

    private fun checkGalleryPermission(){
        if (PermissionUtil().requestPermission(
            this,
            GALLERY_PERMISSION_REQUEST,
            permission.READ_EXTERNAL_STORAGE,
            )
        ) openGallery()
    }

    private fun openGallery() {
        val intent = Intent().apply {
            setType("image/*")
            setAction(Intent.ACTION_GET_CONTENT)
        }
        startActivityForResult(
            Intent.createChooser(intent, "Select a photo"),
            GALLERY_PERMISSION_REQUEST
        )
    }

    private fun openCamera() {
        val photoUri = FileProvider.getUriForFile(
            this,
            applicationContext.packageName + ".provider",
            createCameraFile()
        )
        startActivityForResult(
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }, CAMERA_PERMISSION_REQUEST
        )
    }

    @Deprecated("Deprecated in Java", ReplaceWith(
        "super.onActivityResult(requestCode, resultCode, data)",
        "androidx.appcompat.app.AppCompatActivity"
    )
    )
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMERA_PERMISSION_REQUEST -> {
                if (resultCode != Activity.RESULT_OK) return
                val photoUri = FileProvider.getUriForFile(
                    this,
                    applicationContext.packageName + ".provider",
                    createCameraFile()
                )
                uploadImage(photoUri)
            }
            GALLERY_PERMISSION_REQUEST -> data?.let { uploadImage(it.data) }
        }
    }

    private fun uploadImage(imageUri: Uri?) {
        val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
        uploaded_image.setImageBitmap(bitmap)
        uploadChooser?.dismiss()
        requestCloudVisionApi(bitmap)
    }

    private fun requestCloudVisionApi(bitmap: Bitmap) {

    }

    inner class ImageRequestTask constructor(
        activity: MainActivity,
        val request: Vision.Images.Annotate
    ) : AsyncTask<Any, Void, String>() {

        private val weakReference: WeakReference<MainActivity>

        init {
            weakReference =  WeakReference(activity)
        }


        override fun doInBackground(vararg p0: Any?): String {
            try {
                val response = request.execute()
                return convertResponseToString(response)

            } catch (e: Exception) {
                e.printStackTrace()
            }
            return "분석 실패"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }

    private fun convertResponseToString(response: BatchAnnotateImagesResponse): String {
        val message = StringBuilder("분설 결과\n")
        val labels = response.responses[0].labelAnnotations

        labels?.let {
            it.forEach {
                message.append(String.format(Locale.US, "%.3f: %s", it.score, it.description))
                message.append("\n")
            }
            return message.toString()
        }
        return "분석 실패"
    }

    private fun createCameraFile(): File {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File(dir, FILE_NAME)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            GALLERY_PERMISSION_REQUEST -> {
                if (PermissionUtil().permissionGranted(
                        requestCode,
                        GALLERY_PERMISSION_REQUEST,
                        grantResults
                    )
                ) openGallery()
            }

            CAMERA_PERMISSION_REQUEST -> {
                if (PermissionUtil().permissionGranted(
                        requestCode,
                        CAMERA_PERMISSION_REQUEST,
                        grantResults
                    )
                ) openCamera()
            }
        }
    }
}