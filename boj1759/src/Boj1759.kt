import java.io.*
import java.nio.Buffer

// 3<=lc<=15
// 최소 한개 모음/ 두개 자음
// 오름차 정렬

val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
var L = 0
var C = 0
lateinit var charArr: CharArray
lateinit var sec: CharArray


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l, c) = br.readLine().split(" ").map { it.toInt() }
    L = l
    C = c
    sec = CharArray(L)
    charArr = br.readLine().split(" ").map { it.get(0) }.toCharArray().sortedArray()
    dfs(0, 0)
}

fun dfs(Level: Int, x: Int) {
    if (Level == L) {
        var vowelsCnt = 0
        var consonantCnt = 0
        sec.forEach{
            it-> if(vowels.contains(it)){
                vowelsCnt++
            }else{
                consonantCnt++
            }
        }
        if(vowelsCnt>0 && consonantCnt >1) println(sec.joinToString(""))
    } else {
        for (i in x until C) {
            sec[Level] = charArr[i]
            dfs(Level + 1, i + 1)
        }
    }

}