package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     * Solution 1 with O(n^2)
     * public static int[] twoSum(int[] nums, int target) {
     * int[] solution = { -1, -1 };
     * for (int i = 0; i <= nums.length; i++) {
     * for (int j = i + 1; j < nums.length; j++) {
     * if (nums[i] + nums[j] == target) {
     * solution[0] = i;
     * solution[1] = j;
     * }
     * }
     * }
     * return solution;
     * }
     */

    // Solution 2 with O(n) using a HashMap
    public static int[] betterTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[] { numsMap.get(complement), i };
            }
            numsMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] test = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(betterTwoSum(test, 9)));
    }
}
