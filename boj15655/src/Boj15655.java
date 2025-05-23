import java.util.Arrays;
import java.util.Scanner;

public class Boj15655 {
    static int[] arr;
    static int[] seq;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        seq = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0,0);
        //
    }


    static void dfs(int L,int x) {
        if (L == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(seq[i] + " ");
            }
            System.out.println(sb.toString().trim());
        } else {
            for (int i = x; i < n; i++) {

                seq[L] = arr[i];
                dfs(L + 1,i+1);


            }
        }
    }
}

