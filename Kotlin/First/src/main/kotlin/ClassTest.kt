fun main(args: Array<String>) {
    println("\n==========================\n")

    Test1().showInfo()
    Test1("psw", 50).showInfo()

    println("\n==========================\n")

    Test2("hi2").showInfo()
    Test2("hi2", 50).showInfo()

    println("\n==========================\n")

    ChildClass("HI").sayHello()

}

class Test1 {
    var sName: String = "Test1"
    var nAge : Int = 10

    //생성자
    constructor(){
        println(this.toString())
    }

    constructor(name: String, age: Int){
        sName = name
        nAge = age
    }

    fun showInfo() = println("${sName} : ${nAge}")
}

// 생성자를 ()로 처리하는 클래스
// 클래스에서 다른 생성자를 정의하려면
// constructor 뒤에 : this(정의한 값)을 덛붙힌다.
class Test2(name: String){
    var sName : String = "Test2"
    var nAge : Int = 10

    init {
        sName = name
    }

    constructor(name: String, age: Int) : this(name){
        sName = name
        nAge = age
    }

    fun showInfo () = println ("${sName} : ${nAge}")
}

// 상속을 받으려면 open 으로 정의
open class ParentClass(msg : String){
    var message = msg
    fun sayHello() = println(message)
}

class ChildClass(m : String) : ParentClass(m){}
