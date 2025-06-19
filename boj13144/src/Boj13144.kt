import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    var rt = 0
    val set = mutableSetOf<Int>()
    var ans = 0L



    for(lt in 0 until n){
        //println("lt= $lt rt= $rt ans = $ans set= $set")
        while (rt<n&& lt<=rt&& !set.contains(list[rt])){
            set.add(list[rt++])
        }
        // 와 하나도 안겹치고 10만 갔을때 10만-0 + 10-1 ... 10만-9만9천 따라서 50억임 그래서 long타입으로 해야함
        ans+= rt-lt
        set.remove(list[lt])
    }
    println(ans)
}


/*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val set = mutableSetOf<Int>()
    var ans = 0L
    var rt = 0
// 어렵
    for (lt in 0 until n) {
        while (rt < n && !set.contains(arr[rt])) {
            set.add(arr[rt])
            rt++
        }
        // 현재 lt를 시작으로 하는 고유 부분 수열의 개수는 (rt - lt)
        ans += (rt - lt)
        set.remove(arr[lt]) // lt 이동을 위해 제거
    }

    println(ans)
}*/
