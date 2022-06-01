fun main(args: Array<String>) {

    var doubleV : Double = 110.1111
    var floatV : Float = 110.1f
    var longV : Long = 100
    var intV : Int = 20
    var shortV : Short = 30
    var byteV : Byte = 10

    println(doubleV)
    println(floatV)
    println(longV)
    println(intV)
    println(shortV)
    println(byteV)

    doubleV = intV.toDouble()

//    doubleV = intV as Double 불가능

    intV = doubleV.toInt()

    // 문자열로 변환
    println ( byteV.toString() )

    // 문자를 숫자로 변환
    val sum = "123".toLong() + 10
    println()
    println(sum)
}