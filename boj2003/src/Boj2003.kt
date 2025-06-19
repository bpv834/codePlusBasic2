import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    var lt = 0
    var sum = 0
    var ans = 0

    for (rt in 0 until n) {
        val value = list[rt]
        sum += value

        while (lt < rt && sum > m) {
            sum -= list[lt++]
        }

        if (sum == m) {
            ++ans
        }
    }
    println(ans)

}