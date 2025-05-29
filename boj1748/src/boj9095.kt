import java.io.BufferedReader
import java.io.InputStreamReader

var n =0
val arr1 = arrayOf(1,2,3)
var ans=0;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

  /*  for(i in 0 until t){
        n= br.readLine().toInt()
        val dp = IntArray(n+1)
        dp[1]=1
        dp[2]=2
        dp[3]=4
        for(j in 4 ..n){
            dp[j]= dp[j-3]+dp[j-2]+dp[j-1]
        }
        println(dp.joinToString())
    }*/

    for(t in 0 until T){
        n=br.readLine().toInt()
        ans=0
        dfs(0,0)
        println(ans)
    }
}

fun dfs(i:Int, sum:Int){
    if(sum>n) return
    if(sum== n){
        ans++
        return
    }else{
        for(j in 0 until 3){
            dfs(j,sum+arr1[j])
        }

    }

}