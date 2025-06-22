import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var ans = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val q = LinkedList<Pair<Int, Int>>()
    val chArr = IntArray(100001)
    q.add(Pair(n, 0))


    while (!q.isEmpty()) {
        val pair = q.poll()
        if (pair.first >= 0 && pair.first <= 100000) {
            if (pair.first == k) {
                ans = pair.second
                break
            }
            if (chArr[pair.first] != 1) {
                chArr[pair.first] = 1
                q.add(Pair(pair.first - 1, pair.second + 1))
                q.add(Pair(pair.first + 1, pair.second + 1))
                q.add(Pair(pair.first * 2, pair.second + 1))
            }
        }

    }
    println(ans)
}