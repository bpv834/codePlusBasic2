import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, p) = br.readLine().trim().split(" ").map { it.toInt() }
    val str = br.readLine()
    val resultArr = br.readLine().split(" ").map { it.toInt() } // a c g t
    val q = LinkedList<Char>()
    val map: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
    var ans = 0

    for(i in 0 until p){
        q.add(str.get(i))
        map.put(str.get(i), map.getOrDefault(str.get(i), 0) + 1)
    }
    if (map.getOrDefault('A', 0) >= resultArr[0] &&
        map.getOrDefault('C', 0) >= resultArr[1] &&
        map.getOrDefault('G', 0) >= resultArr[2] &&
        map.getOrDefault('T', 0) >= resultArr[3]
    ) {
        ans++
    }


    for (i in p until s) {
        q.add(str.get(i))
        map.put(str.get(i), map.getOrDefault(str.get(i), 0) + 1)

        if (q.size > p) {
            val pollCh = q.poll()
            map.put(pollCh, (map.get(pollCh)!!.toInt() - 1))
        }

        if (map.getOrDefault('A', 0) >= resultArr[0] &&
            map.getOrDefault('C', 0) >= resultArr[1] &&
            map.getOrDefault('G', 0) >= resultArr[2] &&
            map.getOrDefault('T', 0) >= resultArr[3]
        ) {
            ans++
        }
    }
    println(ans)

}