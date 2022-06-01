fun main(args: Array<String>) {
    var name = 222;
//    var name: Int = 222;

    //null 값을 함부로 넣을 수 없다
    //var nameNull : String = null

    var nameNull : String? = null

    println("종결자(;) 없이도 가능")
    println("var 는 읽기쓰기, val 는 읽기전용")

    var nCount : Int = 0
    var name2 = "psw"

    val age = 0
    //age++ 읽기 전용이기 때문에 변경 불가

    // 4. null이 가능하다면 엘비스를 불러주세요
    //var MyMoney : Int = null

    // 5. 모든 것은 먼저 선언되어 있어야 이해할 수 있다.
    //println(message)

    val message = "위에서는 액세스 불가함"
    // 5. 어떻게 변수를 이해했을까?

    println (hiMessage)
}

val hiMessage : String = "Hi"

