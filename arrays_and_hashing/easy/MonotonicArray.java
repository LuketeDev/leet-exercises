package arrays_and_hashing.easy;

public class MonotonicArray {
    // Solution with O(n) time and O(1) space
    public boolean isMonotonic(int[] nums) {
        boolean increasing = false;
        boolean decreasing = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else if (nums[i] < nums[i + 1]) {
                increasing = true;
            } else if (nums[i] > nums[i + 1]) {
                decreasing = true;
            }
            if (increasing && decreasing) {
                return false;
            }
        }
        return true;

    }
}
