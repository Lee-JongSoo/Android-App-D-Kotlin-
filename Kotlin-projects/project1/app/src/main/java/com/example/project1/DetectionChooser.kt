package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.detection_chooser.*

class DetectionChooser : DialogFragment() {

    private var detectionChooserNotifierInterface: DetectionChooserNotifierInterface? = null

    interface DetectionChooserNotifierInterface {
        fun detectLabel()
        fun detectLandmark()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detection_chooser, container, false)
    }

}