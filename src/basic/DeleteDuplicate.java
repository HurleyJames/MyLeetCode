package basic;

import java.util.*;

/**
 * 删除数组中重复的元素，并返回删除后数组的长度
 */
public class DeleteDuplicate {
    public static void main(String[] args) {
        int[] test = new int[]{1, 7, 3, 4, 3, 5, 7, 6, 7};
        System.out.println(deleteReturnSize(test));
        Object[] arr = deleteReturnArray(test);
        for (Object value : arr) {
            System.out.print(value + ", ");
        }
    }

    public static int deleteReturnSize(int[] arr) {
        Set<Integer> sets = new HashSet<>();
        for (int value : arr) {
            sets.add(value);
        }
        return sets.size();
    }

    public static Object[] deleteReturnArray(int[] arr) {
        Set<Integer> sets = new HashSet<>();
        for (int value : arr) {
            sets.add(value);
        }
        return sets.toArray();
    }
}
