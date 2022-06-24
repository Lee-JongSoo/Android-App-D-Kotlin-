package com.example.diary

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val diaryEditText = findViewById<EditText>(R.id.diaryEditText)

        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

        diaryEditText.setText(detailPreferences.getString("detail", ""))

        val runnable = Runnable {
            getSharedPreferences("diary", Context.MODE_PRIVATE).edit {
                putString("detail", diaryEditText.text.toString())
            }

            Log.d("DiaryActivity", "SAVE!!! :: ${diaryEditText.text.toString()}")

        }

        // 글자 하나 입력할 때 마다 저장하는 기능
//        diaryEditText.addTextChangedListener {
//            detailPreferences.edit {
//                putString("detail", diaryEditText.text.toString())
//            }
//        }

        // handler 사용
        diaryEditText.addTextChangedListener {

            Log.d("DiaryActivity", "TextChange :: $it")
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 500)
        }

    }
}