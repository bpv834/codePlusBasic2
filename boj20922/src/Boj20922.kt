import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val(n,k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map{it.toInt()}
    val map = mutableMapOf<Int,Int>()
    var lt=0
    var ans=1
    map.put(list[lt],1)

    for(rt in 1 until n){
        val value = list[rt]
            while (map.getOrDefault(value,0)>=k){
                val removeV = list[lt++]
                map.put(removeV,map.getOrDefault(removeV,0)-1)
            }

        map.put(value,map.getOrDefault(value,0)+1)
        ans= Math.max(ans,rt-lt+1)
    }
    println(ans)
}