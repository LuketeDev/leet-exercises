package arrays_and_hashing.easy;

public class FindPivotIndex {
    // Solution 1 in O(n^2) time
    public int pivotIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length - i; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum)
                return i;
            else {
                rightSum = 0;
                leftSum = 0;
            }
        }
        return -1;
    }

    // Solution 2 in O(n) time
    public int pivotIndexTwo(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
