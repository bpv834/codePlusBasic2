import java.io.*
import java.util.*

lateinit var preArr: IntArray
lateinit var sec: IntArray
lateinit var arr: IntArray
val sb = StringBuilder()
var n = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val str = br.readLine()
        if (str.equals("0")) break
        val intArr =str.split(" ").map { it.toInt() }.toIntArray()
        n=intArr[0]
        arr= IntArray(n)
        sec = IntArray(6)
        preArr = IntArray(6)
        for(i in 0 until n){
            arr[i] =intArr[i+1]
        }

        dfs(0, 0)
        sb.append('\n')
    }
    print(sb.trim())

}

fun dfs(L: Int, x: Int) {
    if (L == 6) {
        sb.append(sec.joinToString(" "))
        sb.append('\n')
    } else {
        for (i in x until n) {
            sec[L] = arr[i]
            dfs(L + 1, i + 1)

        }
    }
}