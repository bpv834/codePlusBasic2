import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var minDiff = Int.MAX_VALUE
    var lt = 0
    var rt = n - 1
    var ansLt = 0
    var ansRt = n - 1

    while (lt < rt) {
        val sum = list[lt] + list[rt]

        if (Math.abs(0 - minDiff) > Math.abs(0 - sum)) {
            minDiff = sum
            ansLt = lt
            ansRt = rt
        }
        if (sum > 0) {
            rt--
        } else {
            //0이여도 lt를 ++ 해서 종료직전까지 이동이 가능함
            lt++
        }
    }
    println("${list[ansLt]} ${list[ansRt]}")

}