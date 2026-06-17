package arrays_and_hashing.easy;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    // Solution 1 using sorting for O(n log n) time and O(1) space
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int w = nums[nums.length - 1];
        int x = nums[nums.length - 2];
        int y = nums[0];
        int z = nums[1];
        return (w * x) - (y * z);
    }

    // Solution 2 using linear search for O(n) time and O(1) space
    public int maxProductDifferenceTwo(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return (max1 * max2) - (min1 * min2);

    }
}
