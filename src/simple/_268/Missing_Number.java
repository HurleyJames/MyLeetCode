package simple._268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 寻找丢失的数
 * 例如，序列为 [0, 1, 3] 时，缺失的数为2
 */
public class Missing_Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(lossNum(str));
        System.out.println(findMissing(str));
    }

    /**
     * 通过排序找缺失的位置的元素
     *
     * @param str
     * @return
     */
    public static int lossNum(String str) {
        int missNum = 0;
        int[] nums = stringToIntArray(str);
        // 先必须排序
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j + 1] - nums[j] != 1) {
                missNum = nums[j] + 1;
            }
        }
        return missNum;
    }

    /**
     * 使用哈希表的方式
     *
     * @param str
     * @return
     */
    public static int missingNumber(String str) {
        int[] nums = stringToIntArray(str);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!set.contains(number)) {
                return number;
            }
        }
        return -1;
    }


    /**
     * 通过本应长度的总和减去所有数的总和，即为差值
     *
     * @param str
     * @return
     */
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
