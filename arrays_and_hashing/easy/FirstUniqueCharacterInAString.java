package arrays_and_hashing.easy;

public class FirstUniqueCharacterInAString {
    // Solution 1 with O(n) time and space
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
