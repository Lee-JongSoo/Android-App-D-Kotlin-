fun main(args: Array<String>) {
    // InterTest
    InterImpl().TestFunc()
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

class InterImpl : InterTest {
    override fun TestFunc() {
        println("InterImpl InterTest")
    }
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