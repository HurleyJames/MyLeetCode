package simple._001;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two_Sum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j && (nums[i] + nums[j] == target)) {
                    System.out.println("Two numbers: " + nums[j] + " and " + nums[i]);
                    System.out.println("Indices of the two numbers: " + j + " and " + i);
                    return nums;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("Two numbers: " + nums[i] + " and " + complement);
                System.out.println("Indices of the two numbers: " + i + " and " + map.get(complement));
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("Two numbers: " + complement + " and " + nums[i]);
                System.out.println("Indices of the two numbers: " + map.get(complement) + " and " + i);
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the target:");
        int target = input.nextInt();
        System.out.println("Please input the length of array:");
        int len = input.nextInt();
        int[] nums = new int[len];
        System.out.println("Please input the elements of this array:");
        for (int i = 0; i < len; i++) {
            nums[i] = input.nextInt();
        }

//        twoSum1(nums, target);
//        twoSum2(nums, target);
//        twoSum3(nums, target);

    }
}
