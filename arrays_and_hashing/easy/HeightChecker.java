package arrays_and_hashing.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeightChecker {
    // Solution 1 with O(n log n) time and O(n) space
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        int res = 0;
        Arrays.sort(expected);
        if (Arrays.equals(expected, heights)) {
            return 0;
        }
        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                res++;
            }
        }
        return res;
    }

    // Solution 2 using constraints and counting sort with O(n) time and O(1) space
    public int heightCheckerTwo(int[] heights) {
        int[] freq = new int[101];
        for (int h : heights) {
            freq[h]++;
        }
        int mismatch = 0;
        int expectedHeight = 1;

        for (int h : heights) {
            while (freq[expectedHeight] == 0) {
                expectedHeight++;
            }

            if (h != expectedHeight) {
                mismatch++;
            }

            freq[expectedHeight]--;
        }
        return mismatch;
    }
}
