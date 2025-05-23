import java.util.Arrays;
import java.util.Scanner;

public class boj15654 {
    static int[] arr;
    static int[] seq;
    static int n;
    static int m;
    static int[] visit;

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         arr=new int[n];
         seq= new int[m];
         visit=new int[n];

         for (int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
         }
         Arrays.sort(arr);
         dfs(0);
    }


    static void dfs(int L) {
         if(L==m){
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < m; i++) {
                 sb.append(seq[i]+" ");
             }
             System.out.println(sb.toString().trim());
         }else{
             for (int i = 0; i < n; i++) {
                 if(visit[i]!=1){
                     visit[i]=1;
                     seq[L]= arr[i];
                     dfs(L+1);
                     visit[i]=0;

                 }
             }
         }
    }
}
