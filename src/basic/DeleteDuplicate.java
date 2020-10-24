package basic;

import java.util.*;

/**
 * 删除数组中重复的元素，并返回删除后数组的长度
 */
public class DeleteDuplicate {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 3, 4, 5, 6, 6, 7};
        int[] arr = new int[]{};
        System.out.println(delete(test));
    }

    public static int delete(int[] arr) {
        int len = arr.length;
        Set<Integer> sets = new HashSet<>();
        for (int value : arr) {
            sets.add(value);
        }
        return sets.size();
    }

}
