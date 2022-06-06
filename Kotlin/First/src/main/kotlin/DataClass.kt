fun main(args: Array<String>) {

    // 1. 일반 클래스로 데이터값을 할당해보기
    var a = A()
    a.power = 3
    a.name = "snake"

    println(a)
    println("\n=============================\n")

    // 2. data class 사용해보기
    var d0 = DataA("AAA", 3)
    var d = DataA(nLevel = 3)

    println(d0)
    println("\n=============================\n")

    println(d)
    println("\n=============================\n")

    // 3. data class 에서 body 적용해보기
    var d3 = DataA(nLevel = 11)
    d3.job = "programmer"
    println(d3)
    println("\n=============================\n")


    // 4. data class 에서 copy 메소드
    var d4 = d3.copy(name = "lee")
    println(d4)
    println("\n=============================\n")


    // 5. data class 에서 destruction
    var (name) = d4
    println(name)
    println("\n=============================\n")


    var (name2, power) = d4
    println ("$name2 $power ")
    println("\n=============================\n")

}

class A {
    var name   : String = ""
    var power  : Int    = 0
}

data class DataA(var name : String = "no", var nLevel : Int){
    var job : String = ""
    operator fun plus(d:DataA){this.nLevel + d.nLevel}
}