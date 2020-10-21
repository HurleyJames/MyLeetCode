package basic;

/**
 * 求两个数之间的所有素数之和
 */
public class PrimeSum {

    public static void main(String[] args) {
        System.out.println(new PrimeSum().primeSum(2, 5));
    }

    /**
     * 判断一个数是否是素数
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        boolean flag = true;
        if (n < 0 || n == 1) {
            // 小于0或或者为1时，显然不是素数
            flag = false;
        } else if (n == 2) {
            // 2是素数
            flag = true;
        } else if (n % 2 == 0) {
            // 如果是2的倍数，也不是素数
            flag = false;
        } else { 
            for (int i = 3; i < Math.sqrt(n) + 1; i += 2) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * primeSum函数返回素数和
     *
     * @param n int整型 n为正整数，且n>1
     * @param m int整型 m为正整数，且m>n
     * @return int整型
     */
    public int primeSum(int n, int m) {
        // write code here
        int sum = 0;
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
