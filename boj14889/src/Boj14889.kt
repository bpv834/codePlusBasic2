import java.io.*
import java.util.*

var n = 0
lateinit var visits: BooleanArray
lateinit var board: Array<MutableList<Int>>
lateinit var teamSt: MutableList<Int>
lateinit var teamLk: MutableList<Int>
var ans = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    visits = BooleanArray(n + 1)
    board = Array(n + 1) { mutableListOf() }



    for (i in 1..n) {
        val rows = br.readLine().split(" ").map { it.toInt() }
        board[i].add(0)
        board[i].addAll(rows)
    }

    dfs(0, 1, mutableListOf())
    println(ans)

}

fun dfs(L: Int, x: Int, sec: MutableList<Int>) {
    if (L == n / 2) {
        teamSt = mutableListOf()
        teamLk = mutableListOf()
        for (i in 1..n) {
            if (visits[i]) {
                teamSt.add(i)
            } else {
                teamLk.add(i)
            }
        }
        val sum1 = calculationScore(teamSt)
        val sum2 = calculationScore(teamLk)
        ans = Math.min(Math.abs(sum1-sum2),ans)


    } else {
        for (i in x..n) {
            if (!visits[i]) {
                visits[i] = true
                sec.add(i)
                dfs(L + 1, i + 1, sec)
                sec.removeAt(L)
                visits[i] = false
            }
        }
    }
}

fun calculationScore(list: MutableList<Int>): Int {
    var sum = 0
    for (i in 0 until n / 2 - 1) {
        for (j in i + 1 until n / 2) {
            val a1 = list.get(i)
            val a2 = list.get(j)

           sum += board[a1][a2] + board[a2][a1]

        }
    }
    return sum
}