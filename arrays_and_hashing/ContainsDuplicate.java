package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    // Solution in O(n)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.add(num))
                return true;
            visited.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(test));
    }
}
