import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Boj2309 {

    static int[] arr;

    static int n;
    static int m;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = 9;
        m = 7;
        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, 0);
    }

    static void dfs(int st, int level, int sum) {
       /* System.out.println(st + " " + level + " " + sum);*/
        if (sum > 100) {
           /* System.out.println("s>100");*/
            return;
        }
        if (level == m) {
         /*   System.out.println("l==m");*/
           /* System.out.println(list);*/
            if (sum == 100) {
                list.sort(null);
                for (int x : list) {
                    System.out.println(x);
                }
                System.exit(0);
            }
        } else {
        /*    System.out.println("else");*/

            for (int i = st; i < n; i++) {
                list.add(arr[i]);
                dfs(i + 1, level + 1, sum + arr[i]);
                list.remove(list.size()-1);
            }

        }
    }
}
