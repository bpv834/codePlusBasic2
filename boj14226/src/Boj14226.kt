import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val set = mutableSetOf<Triple<Int,Int,Int>>()

    val q = LinkedList<Triple<Int, Int, Int>>()
    q.add(Triple(1, 0, 0))
    while (!q.isEmpty()) {
        val value = q.poll()
        if(set.contains(value)) continue
        set.add(value)
       // println(value)
        if (value.first >= 0 ) {
            //  println(value)
            val imt = value.first
            val clip = value.second
            val sec = value.third


            if (imt == n) {
                println(sec)
                break
            }


            // 복사
            q.add(Triple(imt, imt, sec + 1))
            // 붙여넣기
            q.add(Triple(imt + clip, clip, sec + 1))
            // 삭제
            q.add(Triple(imt - 1, clip, sec + 1))
        }
    }

}