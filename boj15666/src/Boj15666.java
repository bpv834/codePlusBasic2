    import java.io.*;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Boj15666 {
        static int n;
        static int m;
        static int[] seq, arr;
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

            String element = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(element);
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            Arrays.sort(arr);
            dfs(0,0);
            bw.flush();
            bw.close();

        }

        static void dfs(int L, int x) throws IOException {
            if (L == m) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < m; i++) {
                    sb.append(seq[i]+" ");
                }
                bw.write(sb.toString());
                bw.write('\n');

            } else {
                int preNum = 0;
                for (int i = x; i < n; i++) {
                    if (preNum != arr[i]) {
                        seq[L] = arr[i];
                        preNum = seq[L];
                        dfs(L + 1, i );
                    }
                }
            }
        }
    }
