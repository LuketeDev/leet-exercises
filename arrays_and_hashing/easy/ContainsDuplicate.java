package arrays_and_hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Solution in O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.add(num))
                return true;
            visited.add(num);
        }
        return false;
    }
}
