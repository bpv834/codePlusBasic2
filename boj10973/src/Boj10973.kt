import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var arr: IntArray
lateinit var ansArr : IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    arr=IntArray(n)
    ansArr=IntArray(n)
    br.readLine().split(" ").forEachIndexed{
        idx,i->arr[idx] =i.toInt()
    }

    val end = n-1
    var idx=-1
    var isSwap=false



    for(i in end-1 downTo 0){
        if(arr[i]>arr[i+1]){
            for(j in end downTo 0){
                if (arr[i] > arr[j]) {
                    swap(i,j)
                    isSwap=true
                    idx = i
                    break
                }
            }
            if(isSwap) break
        }
    }

    if(isSwap){
        for(i in 0 ..idx){
            ansArr[i]= arr[i]
        }
       // println("중간점검 : ${ansArr.joinToString(" ")}")


        for(i in end downTo idx+1){
            //println("i : $i")
            ansArr[n-i+idx] = arr[i]
        }

        print(ansArr.joinToString(" "))
    }
    else{
        println(-1)
    }


}

fun swap(i:Int, j:Int){
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
    //println("swap : ${arr.joinToString () }}")
}