package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 寻找丢失的数
 * 例如，序列为 [0, 1, 3] 时，缺失的数为2
 */
public class LossNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(lossNum(str));
        System.out.println(findMissing(str));
    }

    public static int lossNum(String str) {
        int missNum = 0;
        int[] nums = stringToIntArray(str);
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j + 1] - nums[j] != 1) {
                missNum = nums[j] + 1;
            }
        }
        return missNum;
    }

    public static int findMissing(String str) {
        // write your code here
        int[] nums = stringToIntArray(str);
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            // 求出长度的总和
            sum += i;
        }
        int get = 0;
        for (int i = 0; i < nums.length; i++) {
            // 求出所有数的总和
            get += nums[i];
        }
        // 相减得到的差说明是缺失的那个数
        return sum - get;
    }

    /**
     * 字符串String去除符号后，转化成整型数组
     *
     * @param str
     * @return
     */
    public static int[] stringToIntArray(String str) {
        String rStr = str.replaceAll(",", "");
        int len = rStr.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(rStr.substring(i, i + 1));
        }
        return nums;
    }
}
