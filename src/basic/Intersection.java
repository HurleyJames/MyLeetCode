package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求两个有序数组的公共元素
 */
public class Intersection {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 7, 9, 10, 16};
        int[] b = new int[]{2, 3, 6, 8, 9, 10};
        List<Integer> lists1 = new ArrayList<>();
        List<Integer> lists2 = new ArrayList<>();
        intersection(a, b, lists1);
        for (int list : lists1) {
            System.out.print(list + ", ");
        }

        System.out.println();
        binaryIntersection(a, b, lists2);
        for (int list : lists2) {
            System.out.print(list + ", ");
        }
    }

    /**
     * 适用于两个数组之间的长度接近
     *
     * @param a
     * @param b
     * @param lists
     * @return
     */
    public static List<Integer> intersection(int[] a, int[] b, List<Integer> lists) {
        int len1 = a.length - 1;
        int len2 = b.length - 1;
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (a[i] == b[j]) {
                lists.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return lists;
    }

    /**
     * 适用于两个数组的长度相差较大
     *
     * @param a
     * @param b
     * @param lists
     * @return
     */
    public static List<Integer> binaryIntersection(int a[], int b[], List<Integer> lists) {
        int longArray[];
        int shortArray[];
        if (a.length <= b.length) {
            shortArray = a;
            longArray = b;
        } else {
            shortArray = b;
            longArray = a;
        }
        // 遍历短的数组
        for (int i = 0; i < shortArray.length; i++) {
            // 使用短数组中的每一个元素在长数组中进行二分查找，如果查找到了，说明有公共元素
            int result = Arrays.binarySearch(longArray, shortArray[i]);
            if (result > 0) {
                lists.add(longArray[result]);
            }
        }
        return lists;
    }
}

