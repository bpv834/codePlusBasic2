import java.io.*

// n+1 퇴사
// 각각 상담 완료기간 T일 , 비용 P
var n = 0
lateinit var arr: Array<MutableList<Int>>
var ans = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    arr = Array(n + 1) { mutableListOf() }
    arr[0].addAll(mutableListOf(1, 0))

    for (i in 1..n) {
        arr[i].addAll(br.readLine().split(" ").map { it.toInt() })
    }

/*    arr.forEach {
        println(it.joinToString())
    }*/
    dfs(0, 0)
    println(ans)

}

fun dfs(x: Int, sum: Int) {
    for (i in x..n) {
        val date = arr[i][0]
        val sc = arr[i][1]

        if (i + date <= n + 1) {
            dfs(i + date, sum + sc)
        }
    }
    // 일짜가 n+1 이상이라면 가능한 전부 탐색한 것
    ans= Math.max(ans,sum)

}