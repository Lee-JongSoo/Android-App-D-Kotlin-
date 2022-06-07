package com.example.project1

import android.Manifest.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST = 1000
    private val GALLERY_PERMISSION_REQUEST = 1001
    private val FILE_NAME = "picture.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListener()
    }

    private fun setupListener() {
        upload_image.setOnClickListener {
            UploadChooser().apply {
                addNotifier(object : UploadChooser.UploadChooserNotifierInterface{
                    override fun cameraOnclick() {
                        Log.d("upload", "cameraOnClick")

                        // 권한 작업을 진행 - camera
                        checkCameraPermission()
                    }

                    override fun galleryOnclick() {
                        Log.d("upload", "galleryOnClick")

                        // 권한 작업을 진행 - gallery
                        checkGalleryPermission()
                    }
                })
            }.show(supportFragmentManager, "")
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
        PermissionUtil().requestPermission(
            this,
            GALLERY_PERMISSION_REQUEST,
            permission.READ_EXTERNAL_STORAGE,
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