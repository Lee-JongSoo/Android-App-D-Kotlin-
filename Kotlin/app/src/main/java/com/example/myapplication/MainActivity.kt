package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.step1.StringTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        doTest(FirstTest(::WriteLn))
//        doTest(DataTest(::WriteLn))
        doTest(StringTest(::WriteLn))
    }

    private fun doTest(o : TestClass){
        o.doTest()
    }

    fun WriteLn( any : Any) {
//        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}