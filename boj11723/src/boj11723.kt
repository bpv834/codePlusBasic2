import java.io.*

var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = hashSetOf<Int>()
    val setAll = HashSet<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 1..20) {
        setAll.add(i)
    }

    n = br.readLine().toInt()
    for (i in 0 until n) {
        val option = br.readLine().split(" ")
        when (option[0]) {
            "add" -> {
                set.add(option[1].toInt())
            }

            "remove" -> {
                set.remove(option[1].toInt())
            }

            "check" -> {
                if (set.contains(option[1].toInt())){
                    bw.append("1")
                    bw.append('\n')
                }else{
                    bw.append("0")
                    bw.append('\n')
                }
            }

            "toggle" -> {
                if (set.contains(option[1].toInt())){
                    set.remove(option[1].toInt())
                }else{
                    set.add(option[1].toInt())
                }
            }
            "all" -> {
                set.clear()
                set.addAll(setAll)
            }

            "empty" -> {
                set.clear()
            }

        }
    }
    bw.flush()
    bw.close()
}