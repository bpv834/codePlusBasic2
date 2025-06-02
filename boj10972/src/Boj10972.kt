import java.io.BufferedReader
import java.io.InputStreamReader
lateinit var arr : IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // n 까지의 수를 받아 순열을 만든다.
    // 처음 1의 자리 수만 n 개 받는줄 알고 string으로 오름차순 정렬했다가 틀렸음
    val n = br.readLine().toInt()
    arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val end = n-1
    var isSort = false
    var idx=-1
    for (i in end-1 downTo 0) {
        if(arr[i]<arr[i+1]){
            for(j in end downTo 0){
                if(arr[i]<arr[j]){
                    swap(i,j)
                    isSort = true
                    idx=i
                    break
                }
            }
        }
        if(isSort) break
    }
    if(isSort){
        val ansArr = IntArray(n)
        for(i in 0 ..idx){
            ansArr[i] = arr[i]
        }

        // 바꾼 부분 뒤부턴 오름차순 정렬
        for(i in end downTo idx+1){
            ansArr[n-i+idx] = arr[i]
        }

        println(ansArr.joinToString(" "))


    }else{
        println(-1)
    }
}

fun swap(i:Int, j:Int){
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}