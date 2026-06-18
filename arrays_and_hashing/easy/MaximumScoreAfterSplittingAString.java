package arrays_and_hashing.easy;

public class MaximumScoreAfterSplittingAString {
    // Solution 1 creating splits with O(n^2) time and O(1) space
    public int maxScore(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : left.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }
            for (char c : right.toCharArray()) {
                if (c == '1') {
                    oneCount++;
                }
            }
            int sum = zeroCount + oneCount;
            max = Math.max(max, sum);
        }
        return max;
    }

    // Solution 2 without creating splits with O(n) time and O(1) space
    public int maxScoreTwo(String s) {
        int rightOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rightOnes++;
            }
        }

        int leftZeros = 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            max = Math.max(max, leftZeros + rightOnes);
        }
        return max;
    }
}
