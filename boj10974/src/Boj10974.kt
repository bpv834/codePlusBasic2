import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var array: IntArray
lateinit var visits:BooleanArray
var n =0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n= br.readLine().toInt()
    visits= BooleanArray(n+1)
    array=IntArray(n)
    dfs(0)


}

fun dfs(L : Int){
    if(L==n){
        println(array.joinToString(" "))
    }else{
        for(i in 1 .. n){
            if(!visits[i]){
                array[L]=i
                visits[i]=true
                dfs(L+1)
                visits[i]=false
            }
        }
    }




}


