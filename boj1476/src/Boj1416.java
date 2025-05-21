import java.util.Arrays;
import java.util.Scanner;

public class Boj1416 {
    static int arr[] = new int[3];
    static int ch[] = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();

        }
        int year = 1;
        int a=1;
        int b=1;
        int c=1;
        while (true) {
            if (a % 16 == 0) {
                a=1;
                ch[0] = a++;
            }
            else ch[0] = a++ % 16;

            if (b % 29 == 0) {
                b=1;
                ch[1] = b++;
            }
            else ch[1] = b++ % 29;

            if (c % 20 == 0) {
                c=1;
                ch[2] = c++;
            }
            else ch[2] = c++ % 20;

     /*       System.out.println(Arrays.toString(ch));*/

            if (ch[0] == arr[0] && ch[1] == arr[1] && ch[2] == arr[2]) break;
            year++;
        }
        System.out.println(year);
    }
}
