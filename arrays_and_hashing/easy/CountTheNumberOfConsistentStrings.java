package arrays_and_hashing.easy;

public class CountTheNumberOfConsistentStrings {
    // Solution 1 with O(n*m*k) time
    // where n=words, m=average word length, k=length of allowed
    // indexOf() takes O(k) time
    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (allowed.indexOf(word.charAt(i)) == -1) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    // Solution 2 using boolean array for a O(1) allowed
    // char lookup for an overall O(k + n*m) time
    public int countConsistentStringsTwo(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];

        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        int count = 0;

        for (String word : words) {
            boolean consistent = true;

            for (char c : word.toCharArray()) {
                if (!allowedChars[c - 'a']) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                count++;
            }
        }
        return count;
    }
}
