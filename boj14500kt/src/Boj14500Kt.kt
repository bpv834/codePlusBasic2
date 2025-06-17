import java.io.*
import java.util.*

var n = 0
var m = 0
lateinit var paper: Array<MutableList<Int>>
lateinit var visits: Array<BooleanArray>
var ans = 0
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    n = N
    m = M

    paper = Array(n) { mutableListOf() }
    visits = Array(n) { BooleanArray(m){false}}

    for (i in 0 until n) {
        val str = br.readLine()
        paper[i] = str.split(" ").map { it.toInt() }.toMutableList()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visits[i][j] = true
            dfs(1, i, j, paper[i][j])
            visits[i][j] = false
            calSpecialType(i,j)
        }
    }
    println(ans)

}

fun dfs(dep: Int, y: Int, x: Int, sum: Int) {
    //println("dep : $dep y= $y x= $x sum = $sum")
    if (dep == 4) {
        ans = Math.max(ans, sum)
    } else {
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny>=0 && ny < n && nx>=0 && nx <m&&!visits[ny][nx] ) {
                visits[ny][nx]=true
                dfs(dep+1,ny,nx,sum+paper[ny][nx])
                visits[ny][nx]=false
            }
        }
    }
}

fun calSpecialType(y:Int, x: Int) {
    // ㅏ
    val shapes = arrayOf(
        arrayOf(Pair(0,0),Pair(1,0),Pair(2,0),Pair(1,1)),
        arrayOf(Pair(0,0),Pair(1,0),Pair(1,-1),Pair(1,1)),
        arrayOf(Pair(0,0),Pair(1,0),Pair(1,-1),Pair(2,0)),
        arrayOf(Pair(0,0),Pair(0,1),Pair(0,2),Pair(1,1)),
    )

    shapes.forEach {
        var sum=0
        it.forEach {
            val ny = y+it.first
            val nx = x+it.second
            if(ny<0 || ny >=n || nx <0 || nx >=m ) {
                sum=0
                return@forEach
            }
            sum+=paper[ny][nx]
        }
        ans = Math.max(ans,sum)
    }

}