package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.upload_chooser.*

class UploadChooser : BottomSheetDialogFragment() {

    interface UploadChooserNotifierInterface {
        fun cameraOnclick()
        fun galleryOnclick()
    }

    var uploadChooserNotifierInterface : UploadChooserNotifierInterface? = null

    fun addNotifier(listener: UploadChooserNotifierInterface) {
        uploadChooserNotifierInterface  = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.upload_chooser, container, false)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() {
        upload_camera.setOnClickListener{
            uploadChooserNotifierInterface?.cameraOnclick()
        }

        upload_gallery.setOnClickListener {
            uploadChooserNotifierInterface?.galleryOnclick()
        }
    }
}