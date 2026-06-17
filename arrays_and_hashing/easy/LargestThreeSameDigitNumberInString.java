package arrays_and_hashing.easy;

public class LargestThreeSameDigitNumberInString {
    // Solution 1 in O(n) time and O(1) space
    public String largestGoodInteger(String num) {
        char max = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            char c = num.charAt(i);

            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                max = (char) Math.max(max, c);
            }
        }
        return max == 0 ? "" : String.valueOf(max).repeat(3);
    }
}
