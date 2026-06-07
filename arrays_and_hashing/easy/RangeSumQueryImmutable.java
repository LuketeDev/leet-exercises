package arrays_and_hashing.easy;

public class RangeSumQueryImmutable {
    // Solution in speed O(right-left+1)
    class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i < right + 1; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
