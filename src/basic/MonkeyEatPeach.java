package basic;

import java.util.Scanner;

/**
 * 猴子吃桃问题
 * 猴子第一天摘下N个桃子，当时就吃了一半，还不过瘾，就又吃了一个。第二天又将剩下的桃子吃掉一半，又多吃了一个。以后每天都吃前一天剩下的一半零一个。到第n天在想吃的时候就剩一个桃子了,求第一天共摘下来多少个桃子？
 *
 * 通过读题发现，其递推公式是f(n)=(f(n+1)+1)*2
 */
public class MonkeyEatPeach {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("total = " + eat(n));
    }

    private static int eat(int n) {
        int i = 1;
        int x = 1;
        while (i < n) {
            x = (x + 1) * 2;
            i++;
        }
        return x;
    }
}
