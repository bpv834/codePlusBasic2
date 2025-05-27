
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, k;
    static int[] arr;
    static int[] sec;
    static int ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            StringTokenizer tk =new StringTokenizer(str);

            n = Integer.parseInt(tk.nextToken());
            k = Integer.parseInt(tk.nextToken());
            arr = new int[n];
            sec = new int[k];
            String arrInput = br.readLine();
            StringTokenizer token = new StringTokenizer(arrInput);
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }

            ans = Integer.MAX_VALUE;
            dfs(0, 0);
            bw.write("#" + t + " " + ans);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int L, int x) {
        if (L == k) {
            /* System.out.println(Arrays.toString(sec));*/
            int sum = 0;
            for (int i = 0; i < k - 1; i++) {
                for (int j = i + 1; j < k; j++) {
                    sum += Math.abs(sec[i] - sec[j]);
                }
            }
            ans = Math.min(ans, sum);
        } else {
            for (int i = x; i < n; i++) {
                sec[L] = arr[i];
                dfs(L + 1, i + 1);
            }
        }
    }

}

