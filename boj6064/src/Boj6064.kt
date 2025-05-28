import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    for(i in 0 until T ){
        val (m, n, gm, gn) = br.readLine().split(" ").map { it.toInt() }
        var cnt = 0
        val limit = culLcm(getGcd(m,n),m,n)

        for(i in  gm .. limit step m){
            if((i-1)%n+1==gn){
                cnt=i
                break
            }
        }
        if(cnt!=0) println(cnt)
        else println(-1)

    }
}

fun culLcm(gcd:Int,m:Int, n:Int): Int{
    val a1 = m/gcd
    val a2 = n/gcd
    return gcd*a1*a2
}

fun getGcd(n1:Int, n2:Int):Int{
    if(n2==0) return n1
    return getGcd(n2, n1%n2)
}
