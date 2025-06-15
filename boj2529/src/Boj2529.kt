import java.io.*

var n = 0
lateinit var chArr: CharArray
lateinit var visits: BooleanArray
var max = ""
var min = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    chArr = br.readLine().split(" ").map { it[0] }.toCharArray()
    visits = BooleanArray(10)
    for (i in 0..9) {
        visits[i] = true
        dfs(0, "$i")
        visits[i] = false
    }
    println(max)
    println(min)
}

fun dfs(depth: Int, str: String) {
    if (depth == n) {
        if (max == "") {
            max = str
            min = str
        }
        else if (max.toLong() < str.toLong()) max = str
        if(min.toLong()>str.toLong()) min = str


    } else {
        for (i in 0..9) {
            if (visits[i]) continue
            val last = str.last() - '0'
            if ((chArr[depth] == '<' && last < i) || (chArr[depth] == '>' && last > i)) {
                visits[i] = true
                dfs(depth + 1, str + i)
                visits[i] = false
            }

        }
    }

}