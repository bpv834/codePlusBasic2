import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    var ans = Int.MAX_VALUE
    var sum = 0
    var lt = 0
    for (rt in 0 until n) {
        sum += list[rt]
        while (sum >= s) {
            val cnt = rt-lt+1
            ans= Math.min(ans,cnt)
            sum -= list[lt++]
        }
    }
    if(ans==Int.MAX_VALUE) println(0)else println(ans)
}


/*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    var ans = Int.MAX_VALUE
    var sum = 0
    var lt = 0

    for (rt in 0 until n) {
        sum += list[rt]

        while (sum >= s) {
            val cnt = rt - lt + 1
            ans=Math.min(ans, cnt)
            sum -= list[lt++]
        }

    }
    if (ans == Int.MAX_VALUE) println(0) else println(ans)

}*/
