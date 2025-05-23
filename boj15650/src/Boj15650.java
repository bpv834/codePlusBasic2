import java.util.Arrays;
import java.util.Scanner;

public class Boj15650 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(1,0);

    }


    static void dfs(int st, int L) {
        if (L == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                sb.append(arr[i]+" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            for (int i = st; i <= n; i++) {
                arr[L]=i;
                dfs(i + 1, L + 1);
            }
        }

    }
}
