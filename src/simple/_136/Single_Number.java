package simple._136;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Single_Number {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3};
        int result1 = uniqueAward1(arr);
        int result2 = uniqueAward2(arr);
        int result3 = uniqueAward3(arr);
        int result4 = singleNumber(arr);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     * <p>
     * 用list的方式来解决，注意remove()方法是需要调用删除Object元素，所以需要使用indexOf()方法
     */
    public static int uniqueAward1(int[] nums) {
        // write code here
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (list.contains(nums[i])) {
                list.remove(list.indexOf(nums[i]));
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    /**
     * 使用HashSet方法
     *
     * @param nums
     * @return
     */
    public static int uniqueAward2(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            return it.next();
        }
        return -1;
    }

    /**
     * 使用集合数组相减的方式
     *
     * @param nums
     * @return
     */
    public static int uniqueAward3(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int countArray = 0;
        int countSet = 0;
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
            countArray += nums[i];
        }
        Iterator<Integer> it = sets.iterator();
        while (it.hasNext()) {
            countSet += it.next();
        }

        return 2 * countSet - countArray;
    }

    /**
     * 使用异或运算（位运算）的方法
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
