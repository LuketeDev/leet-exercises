package arrays_and_hashing.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // Solution 1 with O(N) space and time using a frequency map
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, Integer::sum);
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Solution 2 with O(1) space and O(N) time using counter
    public int majorityElementTwo(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
