package basic;

/**
 * 简单找零钱算法
 * 要求优先使用面额大的纸币，假设卖家有足够数量的各种面额的纸币
 */
public class Change {

    public static void main(String[] args) {

    }

    public static int returnChange(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] notes = {1, 2, 5, 10, 20, 50, 100};
        int len = notes.length;
        for (int i = len - 1; i >= 0; i--) {
            if (n >= notes[i]) {
                // 减掉大额纸币后的剩余金额，继续使用该方法
                return returnChange(n - notes[i]) + 1;
            }
        }
        return 0;
    }
}
