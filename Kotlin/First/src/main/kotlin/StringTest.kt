import java.util.*

fun main(args: Array<String>) {

    var sName = "lee"

    // 1.문자열을 추가하는 것은 + 연산자로 가능함 <- Java와 동일
    println (sName + " - The Gamer")

    // 2. """ 이 안에 줄넘김 문자열이 들어갈 수 있다. """
    // Python에 이런 기능이 있다.
    var sLines = """
    1
    2
    3
    4
    5
    6
    7
    8
    9
    """
    println(sLines)

    // 2. """ 이 안에 줄넘김 문자열이 들어갈 수 있다. """
    // Python에 이런 기능이 있다.
    var sFormatter = "$sName <-- sName의 값"
    println(sFormatter)

    // 4. linux bash와 비슷하니
    // ${}안에
    // 함수호출이나 수식처리도 가능함.
    var sBash = "${"지금 시각은 - " + Date()}" // Java class도 가져욜 수 있음.
    println(sBash)
}