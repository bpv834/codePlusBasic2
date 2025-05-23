import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj15656 {
    static int[] arr;
    static int[] seq;
    static int n;
    static int m;

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);

        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        arr = new int[n];
        seq = new int[m];

        String arrStr = br.readLine();
        StringTokenizer token = new StringTokenizer(arrStr);

        int i=0;
        while (token.hasMoreTokens()){
            arr[i++] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        bw.flush();
        bw.close();

    }


    static void dfs(int L) throws IOException {
        if (L == m) {
            for (int i = 0; i < m; i++) {
                bw.write(seq[i]+" ");
            }
            bw.write('\n');
        } else {
            for (int i = 0; i < n; i++) {
                seq[L] = arr[i];
                dfs(L + 1);
            }
        }
    }
}
