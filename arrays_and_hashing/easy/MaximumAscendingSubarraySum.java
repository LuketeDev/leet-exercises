package arrays_and_hashing.easy;

public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        // Solution 1 with O(N) speed
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }

            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
