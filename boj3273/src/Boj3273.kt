import java.io.*
import java.util.*

// 1<= ai<=백만
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().toInt()
    val set = mutableSetOf<Int>()
    var ans=0
    for(i in 0 until n){
        val value = list[i]
        if (set.contains(value)) {
            ans++
        }else{
            val diff = x-value
            set.add(diff)
        }
    }
    println(ans)
}