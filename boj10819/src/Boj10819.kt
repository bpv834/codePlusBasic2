import java.io.BufferedReader
import java.io.InputStreamReader

var ans=0
var n=0
lateinit var visits : BooleanArray
lateinit var arr : IntArray
lateinit var secArr : IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n= br.readLine().toInt()
    arr = IntArray(n)
    secArr = IntArray(n)
    visits = BooleanArray(n)
    arr= br.readLine().split(" ").map { it.toInt() }.toIntArray()
    dfs(0)
    println(ans)

}
fun dfs(L:Int){
    if(L==n){
        calculation()
    }else{
        for(i in 0 until n){
            if(!visits[i]){
                visits[i]=true
                secArr[L] = arr[i]
                dfs(L+1)
                visits[i]=false
            }
        }
    }
}

fun calculation(){
    var sum =0
    for(i in 0 until n-1){
        sum += Math.abs(secArr[i]-secArr[i+1])
    }
    ans = Math.max(ans,sum)
}