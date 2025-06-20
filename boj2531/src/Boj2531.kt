import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    val typeMemo = IntArray(d + 1)
    for (i in 0 until n) {
        arr[i] = br.readLine().trim().toInt()
    }

    var ans = 0
    var curTypeCnt = 0
    for (i in 0 until k) {
        val type = arr[i]
        // 넣기전 값이 0일때만 새로넣는것이기때문에 type수 증가
        if (typeMemo[type] == 0) curTypeCnt++

        typeMemo[type] = typeMemo[type] + 1
    }

    if (typeMemo[c] == 0) ans = curTypeCnt + 1 else ans = curTypeCnt


    for (i in k until n + k - 1) {
        val lt = i - k
        val addType = arr[i%(n)]
        println("i= $i lt= $lt addType = $addType")

        if (typeMemo[addType] == 0) curTypeCnt++
        typeMemo[addType] = typeMemo[addType] + 1

        typeMemo[arr[lt]] = typeMemo[arr[lt]] - 1
        if (typeMemo[arr[lt]] == 0) curTypeCnt--

        if (typeMemo[c] == 0) ans = Math.max(ans, curTypeCnt + 1) else ans = Math.max(ans,curTypeCnt)

    }

    println(ans)
}


/*

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


}*/
