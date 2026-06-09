package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    // Solution 1 with O(n^2) speed and O(n) space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        int[] possibleNums = new int[nums.length];
        for (int i = 0; i < possibleNums.length; i++) {
            possibleNums[i] = i;
        }
        for (int i : possibleNums) {
            if (Arrays.stream(nums).anyMatch(j -> j == i)) {
                disappeared.add(i);
            }
        }
        return disappeared;
    }

    // Solution 2 with O(n) speed and O(1) space
    public List<Integer> findDisappearedNumbersTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
