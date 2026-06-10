package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingAndRepeatedValues {
    // Solution 1 with an incredible O(n^4) time for a n*n grid
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        List<Integer> seen = new ArrayList<>();
        int[] possibles = new int[grid.length * grid.length];
        for (int i = 0; i < possibles.length; i++) {
            possibles[i] = i + 1;
        }
        int repeated = 0;
        int missing = 0;
        for (int[] row : grid) {
            for (int val : row) {
                if (seen.contains(val)) {
                    repeated = val;
                    continue;
                }
                seen.add(val);
            }
        }
        for (int i : possibles) {
            if (seen.stream().noneMatch(j -> j == i)) {
                missing = i;
            }
        }
        return new int[] { repeated, missing };
    }

    // Solution 2 with O(n^2) time and space using a HashSet
    public int[] findMissingAndRepeatedValuesTwo(int[][] grid) {
        int size = grid.length * grid.length;
        Set<Integer> seen = new HashSet<>();
        int repeated = 0;
        int missing = 0;

        for (int[] row : grid) {
            for (int val : row) {
                if (!seen.add(val)) {
                    repeated = val;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[] { repeated, missing };
    }

    /*
     * Solution 3 with O(n^2) time and O(n) space using a HashSet and math
     *
     * First, we compare the sums
     * Let r = repeated, m = missing
     * The expected sum of 1..N is S=N(N+1)/2
     * Let A = The actual sum of the grid
     * Since r appears twice and m is missing: A - S = r - m
     * Let d = r - m
     *
     * Second, we compare the sums of the squares
     * The expected sum of 1..N is SQ=N(N+1)(2N+1)/6
     * Let AQ = The actual sum of the squares of the grid
     * Then: AQ - SQ = r^2 - m^2
     * Using difference of squares: r^2 - m^2 = (r+m)(r-m)
     * So: AQ-SQ = d(r+m)
     * -> r+m = (AQ-SQ)/d
     * Let s = r + m
     * 
     * Finally, solve the system:
     * r - m = d
     * r + m = s
     * =========
     * r = (d + s)/2
     * Then: m = r - d
     */
    public int[] findMissingAndRepeatedValuesThree(int[][] grid) {
        int n = grid.length * grid.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int[] row : grid) {
            for (int val : row) {
                actualSum += val;
                actualSquareSum += (long) val * val;
            }
        }

        long d = actualSum - expectedSum; // r - m
        long s = (actualSquareSum - expectedSquareSum) / d; // r + m

        int repeated = (int) ((d + s) / 2);
        int missing = (int) (repeated - d);

        return new int[] { repeated, missing };
    }
}
