import java.util.Scanner;

public class Boj1107 {
    static int num;
    static int n;
    static int[] broken;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            broken[i] = sc.nextInt();
        }
        // +, - 로 갈수있는 경우 횟수
        int diff =Math.abs( num - 100);



    }
}
