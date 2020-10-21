package basic;

/**
 * [1,2,3]转化为[3,2,1]
 * 寻找能买到的数量最大的商品，要求商品比前一件便宜也比后一件便宜
 */
public class Reorder {

    // TODO

    public static void swap(int m, int n) {
        int temp;
        temp = m;
        m = n;
        n = temp;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param prices int整型一维数组 购物车中的商品价格列表
     * @return int整型
     */
    public int reorder(int[] prices) {
        // write code here
        int num = 0;
        int length = prices.length;

        // reorder
        for (int j = 0; j < length; j++) {
            if (prices[j] < prices[j + 1] && prices[j] < prices[j + 2]) {
                swap(prices[j], prices[j + 1]);
            }
        }

        // add
        for (int i = 0; i < length; i++) {
            if (prices[i] < prices[i - 1] && prices[i] < prices[i + 1]) {
                num++;
            }
        }
        return num;
    }
}
