import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().trim().toInt()
    for (t in 0 until T) {
        val w = br.readLine().trim()
        val k = br.readLine().trim().toInt()

        val idxQueueMap = mutableMapOf<Char, Queue<Int>>()
        var stAns = Int.MAX_VALUE
        var lgAns = Int.MIN_VALUE

        for (i in 0 until w.length) {
            val ch = w.get(i)
            // 처음이면 q 생성
            if (idxQueueMap[ch] == null) {
                val q: Queue<Int> = LinkedList()
                idxQueueMap[ch] = q
            }
            // 상단 널체크
            idxQueueMap[ch]!!.add(i)
            //    println("idxQueueMap[ch] size = ${idxQueueMap[ch]?.size?:0}")

            if (idxQueueMap[ch]!!.size == k) {
                val len = i - idxQueueMap[ch]!!.poll() + 1
                //       println("len=$len ch=$ch i=$i")

                stAns = Math.min(stAns, len)
                lgAns = Math.max(lgAns, len)
            }
        }

        if (stAns == Int.MAX_VALUE) println(-1) else println("$stAns $lgAns")

    }
}