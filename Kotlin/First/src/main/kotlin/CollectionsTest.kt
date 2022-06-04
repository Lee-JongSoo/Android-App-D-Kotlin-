fun main(args: Array<String>) {

    // 읽기전용 -  list. 데이터형을 마구 섞어도 된다.
    var lst = listOf(1, "A", 12.00f, false, true)
    for (i in 0..lst.size - 1) {
        println(lst.get(i).toString())
    }

    println("==============================================\n")

    // 수정가능 - List. 데이터형을 미리 정해야 하는 듯.
    var listEditable = mutableListOf<String>()

    listEditable.add("A")
    listEditable.add("B")
    listEditable.add("C")
    listEditable.add("D")

    for (i in listEditable) {
        println(i)
    }

    println("==============================================\n")

    // remove 메소드로 삭제
    listEditable.removeAt(0)
    for (i in listEditable) {
        println(i)
    }

    println("==============================================\n")

    // Map: java보다 불편한 듯.
    var map = hashMapOf("A" to 1, "B" to 2)
    println(map["A"])
}