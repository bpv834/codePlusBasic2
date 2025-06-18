import java.io.*
import java.util.*

// 로직상 맞지만 n 이 500만이기 때문에 메모리 초과가 일어났다 100만 인 문제엔 잘 돌아갔는데. 따라서 pq는 못쓰고 deque를 써야한다.


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().trim().split(" ").map { it.toInt() }
    val inputArr:IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val resultArr = IntArray(n)
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }

    for(i in 0 until l){
        pq.add(Pair(inputArr[i],i))
        resultArr[i] = pq.peek().first
    }

    for(i in l until n){
        pq.add(Pair(inputArr[i],i))

        // 오래된 애를 빼주자

        while (pq.peek().second<= i-l){
            pq.poll()
        }

        resultArr[i] = pq.peek().first
    }

    println(resultArr.joinToString(" "))
}
