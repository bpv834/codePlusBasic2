import java.util.Arrays;
import java.util.Scanner;

public class Boj15649 {
    static int n, m;
    static int[] arr;
    static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visit= new int[n+1];
        dfs(0);

    }

    static void dfs(int L) {
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                sb.append(arr[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }else{

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0) {
                    visit[i]=1;
                    arr[L] = i;
                    dfs(L+1);
                    visit[i]=0;
                }
            }
        }

    }
}
