package com.example.project1

import android.Manifest.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST = 1000
    private val GALLERY_PERMISSION_REQUEST = 1001

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

    private fun checkCameraPermission(){
        PermissionUtil().requestPermission(
            this, CAMERA_PERMISSION_REQUEST, permission.CAMERA
        )
    }

    private fun checkGalleryPermission(){
        PermissionUtil().requestPermission(
            this,
            GALLERY_PERMISSION_REQUEST,
            permission.READ_EXTERNAL_STORAGE,
            permission.CAMERA
        )
    }
}