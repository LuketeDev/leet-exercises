package arrays_and_hashing.easy;

public class LongestPalindrome {
    // Solution 1 with O(n) time and space
    public int longestPalindrome(String s) {
        int length = 0;
        boolean hasOdd = false;

        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int count : freq) {
            length += (count / 2) * 2;
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }
        return length + (hasOdd ? 1 : 0);
    }

}
