package com.example.myapplication.using

import android.content.Intent
import com.example.myapplication.MainActivity
import com.example.myapplication.javainterlop.javaActivity
import kotlinx.android.synthetic.main.activity_main.*

// 확장함수로 이벤트 핸들러를 등록
fun MainActivity.setClickHandler(){
    btnTest.setOnClickListener {
        var I = Intent(this, javaActivity::class.java)
        startActivity(I)
    }
}

