import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: Array<IntArray>
lateinit var visited: Array<BooleanArray>
var max = 0
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)
var n = 0
var m = 0
var ans = 0;


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    n = x
    m = y
    arr = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) { false } }

    arr.forEachIndexed { rowIndex, ints ->
        val row = br.readLine().split(" ").map { it.toInt() }
        row.forEachIndexed { index, value ->
            arr[rowIndex][index] = value
        }
    }

/*    arr.forEach {
        println(it.joinToString(" "))
    }*/

    for (i in 0 until n) {
        for (j in 0 until m) {
            checkSpecialShape(i, j)
            dfs(i, j, 1, arr[i][j])
        }
    }
    println(ans)
}

fun dfs(y: Int, x: Int, L: Int, sum: Int) {
    if (L == 4) {
        ans = Math.max(ans, sum)
    } else {
        visited[y][x] = true
        for (i in 0 until 4) {
            var ny = y + dy[i]
            var nx = x + dx[i]

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                dfs(ny, nx, L + 1, sum + arr[ny][nx])
            }
        }
        visited[y][x] = false;
    }
}

fun checkSpecialShape(y: Int, x: Int) {
    if (y >= 0 && y < n - 2 && x >= 0 && x < m - 1) {
        // ㅏ 모양
        val value = arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]
        ans = Math.max(ans, value)
    }
    if (y >= 0 && y < n - 2 && x >= 1 && x < m) {
        // ㅓ 모양
        val value = arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]
        ans = Math.max(ans, value)
    }
    if (y >= 0 && y < n - 1 && x >= 1 && x < m - 1) {
        // ㅗ 모양
        val value = arr[y][x] + arr[y + 1][x] + arr[y + 1][x - 1] + arr[y + 1][x + 1]
        ans = Math.max(ans, value)
    }
    if (y >= 0 && y < n - 1 && x >= 0 && x < m - 2) {
        // ㅜ 모양
        val value = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]
        ans = Math.max(ans, value)
    }
}