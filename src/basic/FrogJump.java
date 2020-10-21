package basic;

import java.util.Scanner;

/**
 * 青蛙跳台阶问题
 */
public class FrogJump {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(frogJump(n));
    }

    public static int frogJump(int n) {
        if (n == 0 || n < 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else {
            // 通过观察，发现其实一个 f(n)=f(n-1)+f(n-2) 的规律
            return frogJump(n - 1) + frogJump(n - 2);
        }
    }
}
