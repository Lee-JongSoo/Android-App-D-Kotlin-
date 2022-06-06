fun main(args: Array<String>) {

    // let
    f1().let { value -> println(value) }
    f1().let { println(it) }

    1232.let { it +1 }.let { it*3 }.let { println(it) }
    var add = {a : Int, b : Int -> a+b }
    add(1, 2).let { println(it) }

    var bug : () -> Any? = { null }
    bug()?.let { println(it) }

    // apply() -> 객체 생성과 초기화를 같이 할때 자주 사용됨
    var obj = Test().apply{ sName = "lee"; nAge = 2; }
    obj.aboutMe()

    // run()
    obj.run { sName = "lee"; aging(); sName}.let { println(it) }
    obj.aboutMe()

    // 실행결과를 리턴
    run { 333 + 4 }.let { println(it) }

    // also
    100.let { println(it); it}
        .also { println(it + 1000) }
        .also { println(it + 20) }
        .let { println(it) }

}

fun f1() = 10
class Test{
    var sName : String = "무명씨"
    var nAge : Int = 49
    fun aboutMe() = println("이름은 \"$sName\"이고 나이는 $nAge 입니다. ")
    fun aging() = nAge++
}