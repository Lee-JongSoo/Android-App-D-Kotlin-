import java.util.*

fun main(args: Array<String>) {

    // 일반적인 방법
    val p0 = Player()
    p0.name = "lee"
    p0.status = Status()
    p0!!.status!!.job = "programmer"
    p0!!.status!!.level = 20
    println(p0)

    // 제일 간단한 방법
    var p1 = Player("lee2", Status("Hello", 23))
    println(p1)

    // DSL 이 편리할 수도 있다.
    var p2 = MakePlayer {
        name = "LEEEEEEE - " + Random().nextInt(200).toString()
        status {
            job = "herok"
            level = Random().nextInt(70)
        }
    }
    println(p2)
}

fun MakePlayer(block: Player.() -> Unit): Player = Player().apply(block)
fun Player.status(block: Status.() -> Unit) {
    status = Status().apply(block)
}

// data class
data class Player(var name: String? = null,
                  var status: Status? = null)
data class Status(var job: String? = null, var level: Int? = null)