import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = LongArray(11)

    for(i in 1 ..10){
        arr[i] = (9*i*(Math.pow(10.0, (i-1).toDouble()))).toLong()
    }
    var ans:Long=0;
    val str = br.readLine()

    for(i in 0 until str.length){
        ans+=arr[i]
    }

/*    println(arr.joinToString ())*/
    var str2 = "1"

    for(i in 1 until str.length){
        str2+="0"
    }
    val sum :Long = (str.toLong() - str2.toLong()+1)*str.length

    println(ans+sum)

}