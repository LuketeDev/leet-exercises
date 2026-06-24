package arrays_and_hashing.easy;

class MinimumChangeToMakeAlternatingBinaryString {
    // Solution 1 with O(n) time
    // An alternating string must be either "010101..." or "101010...".
    // Count mismatches against both patterns and return the smaller count.
    // Each mismatch requires exactly one flip.
    public int minOperations(String s) {
        int startsWith0 = 0; // 010101...
        int startsWith1 = 0; // 101010...
        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0) {
                startsWith0++;
            } else if (s.charAt(i) != expected1) {
                startsWith1++;
            }
        }
        return Math.min(startsWith0, startsWith1);
    }
}