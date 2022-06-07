package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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

                        // 권한 작업을 진행
                    }

                    override fun galleryOnclick() {
                        Log.d("upload", "galleryOnClick")

                        // 권한 작업을 진행
                    }
                })
            }.show(supportFragmentManager, "")
        }
    }
}