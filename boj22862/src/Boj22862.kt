import java.io.*
import java.util.*

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().trim().split(" ").map{it.toInt()}
    val list = br.readLine().split(" ").map { it.toInt() }
    val q= LinkedList<Int>()
    var ans =0
    var oddCnt = 0
    var lt=0

    for(rt in 0 until n){
        val value = list[rt]

        if(value%2==1){
            oddCnt++
        }
        while (oddCnt>k&& lt<rt){
            if(q.peek()%2==1){oddCnt--}
            q.poll()
            lt++
        }
        q.add(value)

        ans = Math.max(ans,rt-lt+1-oddCnt)
    }
    println(ans)
}