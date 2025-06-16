import java.io.*

var n = 0
var s = 0
var ans = 0
lateinit var arr: MutableList<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))
    arr = mutableListOf<Int>()
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    arr.addAll(br.readLine().split(" ").map { it.toInt() })
    n = N
    s = S

    dfs(0, 0)
    if (s == 0) println(--ans)
    else println(ans)


}

fun dfs(idx: Int, sum: Int) {
    if (idx==n) {
        if(sum==s) ans++
        return
    }
    // 선택한거
    dfs(idx + 1, sum + arr[idx])
    // 선택 안한거
    dfs(idx + 1, sum)
}

