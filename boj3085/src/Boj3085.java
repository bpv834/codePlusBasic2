import java.util.Scanner;

public class Boj3085 {
    static char[][] board;
    static int n;
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    candy();
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    candy();
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void swap(int y, int x, int ny, int nx) {
        char tmp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = tmp;
    }

    static void candy() {


        // 행 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    ++cnt;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
        }

        // 열 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    ++cnt;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
    }

}
