import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val(n,m) = br.readLine().split(" ").map { it.toInt() }
    val list = IntArray(n)
    for(i in 0 until n){
        list[i] = br.readLine().trim().toInt()
    }
    Arrays.sort(list)
    var lt=0
    var rt=0
    var ans = Int.MAX_VALUE

    while (rt<n&& lt<=rt){
        val a =list[lt]
        val b =list[rt]

        val diff = b-a
        if(diff >=m){
            ans = Math.min(ans,diff)
            lt++
        }else{
            ++rt
        }

    }
    println(ans)

}