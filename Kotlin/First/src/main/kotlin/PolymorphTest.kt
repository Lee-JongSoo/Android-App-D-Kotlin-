fun main(args: Array<String>) {

    var obj1 = baseClass()
    obj1.f1()
    var obj2 = ChildClasses()
    obj2.f1()
    obj2.f2()
    obj2.f2("문자열 파라메터")
    obj2.f2("문자열 파라메터", 100)

    println("\n=============================\n")

    var s = Student("lee")
    (0..99).forEach {s++}
    s.printMe()

    println("\n=============================\n")

    var s2 = Student("Kim")
    s2.nScore = 50

    println("sum of two score is ${s + s2}")
}

open class baseClass {

    // 상속받은 클래스에서 override 하려면 부모클래스에서 open으로 정의.
    open var name = "base"
    open fun f1() = println(this.toString())

    // 외부사용금지 .찍고 메소드 사용못함.
    private fun onlyMyFunc() = println("클래스 내부에서만 생성")

    constructor(){
        onlyMyFunc()
    }
}

class ChildClasses : baseClass(){
    override var name = ""
    override fun f1() = println(this.toString() + "override")
    fun f2() = println("f2")

    //overloading
    fun f2(s : String ) = println("f2:$s ")
    fun f2(s : String, num : Int ) = println("f2: $s, $num ")
}

class Student(s: String) {
    var name: String = s
    var nScore: Int = 0


    operator fun plus(student: Student) : Int{
        return student.nScore + this.nScore
    }

    // ++  변화된 객체를 넘겨야 한다.
    operator fun inc() : Student{
        this.nScore++
        return this
    }

    fun printMe()  = println("${name}는 점수가 $nScore")
}