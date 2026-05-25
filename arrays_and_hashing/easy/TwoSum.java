package arrays_and_hashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     * Solution 1 with O(n^2)
     * public int[] twoSumOne(int[] nums, int target) {
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
    public int[] twoSumTwo(int[] nums, int target) {
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
}
