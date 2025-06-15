import java.io.*

var n = 0
lateinit var st: MutableList<Int>
lateinit var lk: MutableList<Int>
lateinit var board: Array<MutableList<Int>>
lateinit var visits: BooleanArray
var ans = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    board = Array(n + 1) { mutableListOf() }

    for (i in 1..n) {
        val rows = br.readLine()
        board[i].add(0)
        board[i].addAll(rows.split(" ").map { it.toInt() })
    }

    for (i in 1..n / 2) {
        visits = BooleanArray(n + 1)
        dfs(0, 1, i, mutableListOf())
    }

    println(ans)


}

fun dfs(level: Int, x: Int, limit: Int, sec: MutableList<Int>) {
    if (level == limit) {
        st = mutableListOf()
        lk = mutableListOf()

        for (i in 1..n) {
            if (visits[i]) {
                st.add(i)
            } else {
                lk.add(i)
            }
        }
        // st 점수
        val stScore = calculationPoint(st)
        // lk 점수
        val lkScore = calculationPoint(lk)
        // 차이를 ans에 넣는다
        ans = Math.min(ans, Math.abs(stScore - lkScore))


    } else {
        for (i in x..n) {
            if (!visits[i]) {
                visits[i] = true
                sec.add(i)
                dfs(level + 1, i + 1, limit, sec)
                visits[i] = false
                sec.removeAt(sec.size - 1)
            }
        }


    }

}

fun calculationPoint(list: MutableList<Int>): Int {
    var sum = 0
    if (list.size == 1) return 0

    for (i in 0 until list.size - 1) {
        for (j in i + 1 until list.size) {
            val a1 = list[i]
            val a2 = list[j]
            sum+= board[a1][a2]+ board[a2][a1]
        }

    }

    return sum
}