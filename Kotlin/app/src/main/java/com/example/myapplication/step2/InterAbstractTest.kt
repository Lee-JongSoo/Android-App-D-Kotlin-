package com.example.myapplication.step2

import com.example.myapplication.TestClass

class InterAbstractTest(p : (Any) -> Unit ) : TestClass(p){
    override fun doTest() {
        // InterTest
        InterImp().TestFunc()
        var obj : InterTest

        // 추상화
        var obj2 = TestAbstractImp();
        obj2.TestFunc()
        obj2.abstractFunc()

        // static
        println(TestAbstractImp.staticVar);
        TestAbstractImp.staticFunc()

    }

    interface InterTest{
        fun TestFunc()
    }

    class InterImp : InterTest{
        override fun TestFunc() = println("InterImp  InterTest")
    }

    abstract class TestAbstract{
        fun TestFunc() = println("abstract TestFunc")
        abstract fun abstractFunc()
    }

    class TestAbstractImp : TestAbstract(){
        override fun abstractFunc() = println("TestAbstractImp abstractFunc")
        // companion object {} 안에서 구현해야 static 가능
        companion object {
            var staticVar = "companion staticVar"
            fun staticFunc() = println("companion staticFunc")
        }
    }
}