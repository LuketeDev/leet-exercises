package arrays_and_hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    // Solution in O(n^2) time
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Solution in O(n) time
    public int numIdenticalPairsTwo(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int seen = freq.getOrDefault(num, 0);
            count += seen;
            freq.put(num, seen + 1);
        }
        return count;
    }
}
