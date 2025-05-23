import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj15651 {
    static int n;
    static int m;
    static int [] arr;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer tk =new StringTokenizer(str);

        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        arr=new int[m];
        dfs(0);

        bw.flush();  // 꼭 flush 해줘야 출력됨
        bw.close();

    }

    static void dfs(int L) throws IOException {
        if(L==m){
            for (int i = 0; i < L; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();  // 줄바꿈

        }else{
            for (int i = 1; i <= n; i++) {
                arr[L]=i;
                dfs(L+1);
            }
        }
    }
}
