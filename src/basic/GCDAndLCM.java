package basic;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
        int a, b, m;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a integer:");
        a = input.nextInt();
        System.out.println("Please input a integer:");
        b = input.nextInt();
        m = deff(a, b);
        int n = a * b / m;
        System.out.println("最大公约数是：" + m);
        System.out.println("最小公倍数是：" + n);
    }

    public static int deff(int x, int y) {
        int t;
        if (x < y) {
            // 设计成x始终大于y
            t = x;
            x = y;
            y = t;
        }

        while (y != 0) {
           if (x == y) {
               return x;
           }
           else {
               int k = x % y;
               x = y;
               y = k;
           }
        }
        return x;
    }
}
