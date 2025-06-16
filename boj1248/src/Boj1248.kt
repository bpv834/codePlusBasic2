import java.io.*

var n = 0
lateinit var charArray: Array<CharArray>


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    // 배열 크기를 n+1로 한이유는 조건에 charArray[dep + 1][dep + 1]) 를 하기떄문에 결국 n이 4일때 [4][4]를 탐색해야함 쓰진않지만. 그래서 n+1로 크기를 잡음
    charArray = Array(n+1) { CharArray(n+1) }

    val str = br.readLine()
    var idx = 0
    for (i in 0 until n) {
        for (j in i until n) {
            charArray[i][j] = str[idx++]
        }
    }
    dfs(0, mutableListOf(), charArray[0][0])

}

fun dfs(dep: Int, list: MutableList<Int>, sign: Char) {
    for (i in 0 until dep) {
        var sum = 0
        for (j in i until dep) {
            sum += list.get(j)
        }
        // 리턴조건 잘 확인해야함
        if ((sum > 0 && charArray[i][list.size - 1] != '+') || (sum < 0 && charArray[i][list.size - 1] != '-') || (sum == 0 && charArray[i][list.size - 1] != '0')) {
            return
        }
    }


    if (dep == n) {
        println(list.joinToString(" "))
        System.exit(0)
    } else {
        when (sign) {
            '+' -> {
                for (i in 1..10) {
                    list.add(i)
                    dfs(dep + 1, list, charArray[dep + 1][dep + 1])
                    list.removeAt(list.size - 1)
                }
            }

            '-' -> {
                for (i in -10..-1) {
                    list.add(i)
                    dfs(dep + 1, list, charArray[dep + 1][dep + 1])
                    list.removeAt(list.size - 1)
                }
            }

            '0' -> {
                list.add(0)
                dfs(dep + 1, list, charArray[dep + 1][dep + 1])
                list.removeAt(list.size - 1)
            }
        }
    }
}

