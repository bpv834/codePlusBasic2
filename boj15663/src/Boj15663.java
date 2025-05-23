import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj15663 {
    static int[] seq;
    static int n;
    static int m;
    static ArrayList<Integer> list;
    static int[] visit;

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        list = new ArrayList<>();


        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);

        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        seq = new int[m];

        String arrStr = br.readLine();
        StringTokenizer token = new StringTokenizer(arrStr);

        while (token.hasMoreTokens()) {
            int num = Integer.parseInt(token.nextToken());
            list.add(num);

        }
        visit = new int[list.size()];
        list.sort(null);
        dfs(0);
        bw.flush();
        bw.close();

    }


    static void dfs(int L) throws IOException {
        if (L == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seq.length; i++) {
                sb.append(seq[i] + " ");
            }
            bw.write(sb.toString());
            bw.write('\n');


        } else {
            int bf=0;
            for (int i = 0; i < list.size(); i++) {
                if (visit[i] == 0 &&bf!= list.get(i)) {
                    visit[i] = 1;
                    seq[L] = list.get(i);
                    bf = list.get(i);
                    dfs(L + 1);
                    visit[i] = 0;
                }

            }
        }
    }
}
