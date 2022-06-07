package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.step3.PropertiesTest
import com.example.myapplication.using.setClickHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        doTest(FirstTest(::WriteLn))
//        doTest(DataTest(::WriteLn))
//        doTest(StringTest(::WriteLn))
//        doTest(AnyTypeTest(::WriteLn))
//        doTest(FunctionTest(::WriteLn))
//        doTest(ConditionTest(::WriteLn))
//        doTest(LabelTest(::WriteLn))
//        doTest(CollectionsTest(::WriteLn))
//        doTest(ExceptionTest(::WriteLn))
//        doTest(ClassTest(::WriteLn))
//        doTest(PolymorphTest(::WriteLn))
//        doTest(InterAbstractTest(::WriteLn))
//        doTest(DataClassTest(::WriteLn))
//        doTest(ObjectTest(::WriteLn))
//        doTest(LambdasTest(::WriteLn))
//        doTest(ExtFuncTest(::WriteLn))
//        doTest(ExtFunc2Test(::WriteLn))
//        doTest(ClosureTest(::WriteLn))
//        doTest(DSLTest(::WriteLn))
//        doTest(CurryngTest(::WriteLn))
//        doTest(InfixTest(::WriteLn))
//        doTest(MultiReturnTest(::WriteLn))
//        doTest(InitTest(::WriteLn))
        doTest(PropertiesTest(::WriteLn))

        // using 확장함수
        setClickHandler()
    }

    private fun doTest(o : TestClass){
        o.doTest()
    }

    fun WriteLn( any : Any) {
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}