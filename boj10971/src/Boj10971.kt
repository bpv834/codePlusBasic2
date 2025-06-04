import java.io.*

var n = 0
lateinit var arr: Array<MutableList<Int>>
lateinit var visits: BooleanArray
var ans = Int.MAX_VALUE
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    arr = Array(n + 1) {
        mutableListOf()
    }
    visits = BooleanArray(n + 1)

    for (i in 1..n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        arr[i].add(0)
        arr[i].addAll(row)
    }

    for (i in 1..n) {
        visits[i] = true
        dfs(1, i, i, 0)
        visits[i] = false
    }
    println(ans)

}

fun dfs(L: Int, pre: Int, fp: Int, sum: Int) {
   // println("$L $pre $fp $sum")
    if (L == n) {
        //println("l==n")
        if(arr[pre][fp]==0) return
        val value = sum+arr[pre][fp]
       // println(value)
        ans = Math.min(ans,value)

    } else {
        for (i in 1..n) {
            if (!visits[i]) {
                if(arr[pre][i]!=0){
                    visits[i] = true
                    dfs(L + 1, i,fp, sum+arr[pre][i])
                    visits[i]=false
                }
            }
        }

    }

}