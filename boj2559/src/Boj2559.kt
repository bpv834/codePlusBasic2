import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = br.readLine().split(" ").map{it.toInt()}
    val arr :IntArray=br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var sum =0
    for(i in 0 until k){
        sum+=arr[i]
    }
    var max = sum
    var lt =0
    val rt = k

    for(i in rt until n){
        sum += arr[i]
        sum -= (arr[lt++])
        max = Math.max(max,sum)

    }
    println(max)
}