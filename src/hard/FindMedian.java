package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 寻找两个有序数组的上中位数，要求时间复杂度是O(logN)
 * 难度Hard
 */
public class FindMedian {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 6};
        int[] arr2 = new int[]{4, 6, 8, 10};
        System.out.println(findMedian(arr1, arr2));
    }

    public static int findMedian(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            throw new RuntimeException("两个数组都为空");
        } else if (arr1 == null) {
            return arr2[(arr2.length - 1) / 2];
        } else if (arr2 == null) {
            return arr1[(arr1.length - 1) / 2];
        }



        return 0;

//        时间复杂度不满足要求
//        List<Integer> lists = new ArrayList<>();
//        for (Integer n : arr1) {
//            lists.add(n);
//        }
//        for (Integer m : arr2) {
//            lists.add(m);
//        }
//        Collections.sort(lists);
//        for (Integer num : lists) {
//            System.out.print(num + ", ");
//        }
//        int len = lists.size();
//        int index;
//        if (len / 2 == 0) {
//            index = len / 2;
//        } else {
//            index = (len + 1) / 2;
//        }
//        return lists.get(index - 1);
    }
}
