import java.util.*

fun main(args: Array<String>) {

    /**
     * Any를 왜 사용하는가?
     * 문자열 처리, Unit형, Nothing형(ex: TODO)
     */

    var everybody : Any

    everybody = 1111
    everybody = "lee"
    everybody = 221.010101
    everybody = 12.00f

    // is와 !(not) 연산자로 어떤 데이터 형인지 채크가 가능함.
    if (everybody !is String) {
        if (everybody is Float) {
            println("float!!")
        }
    }

    // 2. null은 어떻게 해야할까?
    //var everybody : Any?
    // everybody = null

    // 3. 값을 비교하기

    println(everybody == 12.00f)
    println(everybody.equals(12.00f))

    AllPrint(123123)
    AllPrint("hi")
    AllPrint(Date())

    // Unit형은 값이 없음을 정의하는 형
    var pFunc : (String) -> Unit = { println(it)}
    pFunc("hihihi")

    // Nothing형은 미래가 없음을 알리는 형
    //TODO("이거 구현해야 해여.. 일단 실행했으니 종료합니다.")
}

fun AllPrint(a : Any) = println(a.toString())