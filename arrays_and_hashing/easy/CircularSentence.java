package arrays_and_hashing.easy;

public class CircularSentence {
    // Solution 1 with O(n) time and O(1) space
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(words[i].length() - 1) == words[(i + 1) % words.length].charAt(0)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
