import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val chList = IntArray(d + 1)
    val nList = IntArray(n)
    var typeCnt = 0
    var max = 0


    for (i in 0 until n) {
        nList[i] = br.readLine().trim().toInt()
    }

    for (i in 0 until k) {
        val value = nList[i]
        if (chList[value] == 0) {
            typeCnt++
        }
        chList[value] = chList[value] + 1
    }
    max = if (chList[c] == 0) typeCnt + 1 else typeCnt

    var lt = 0
    var rt = k

    while (true) {
        if (lt == n) break
        val newV = nList[rt % n]
        val removeV = nList[lt]

        // 넣기전에 값이 0 이면 새로운것을 넣는거니 종류 +1
        if (chList[newV] == 0) typeCnt++
        // 넣어준다
        chList[newV] = chList[newV] + 1
        // 뺄걸 빼준다
        chList[removeV] = chList[removeV] - 1
        //println("lt = $lt rt = ${rt%n} chlist = ${chList.joinToString(" ")}" )

        // 빼고나서 값이 0이면 종류에서 1을 빼준다
        if (chList[removeV] == 0) typeCnt--
        val totalCnt = if(chList[c]==0) typeCnt+1 else typeCnt

        max = Math.max(max, totalCnt)

        ++lt
        ++rt
    }
    println(max)


}