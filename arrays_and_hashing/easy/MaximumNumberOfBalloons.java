package arrays_and_hashing.easy;

public class MaximumNumberOfBalloons {
    // Solution in O(n) time and O(1) space
    public int maxNumberOfBalloons(String text) {
        // all 26 lowercase english letters
        int[] freq = new int[26];
        for (int i = 0; i < text.length(); i++) {
            // letter 'a' adds to index 0
            freq[text.charAt(i) - 'a']++;
        }

        // the word 'balloon' contains 2 'l' and 'o',
        // so we divide by 2 for normalization
        freq['l' - 'a'] /= 2;
        freq['o' - 'a'] /= 2;

        int maxBalloons = Integer.MAX_VALUE;

        // use "balon" for unique chars
        for (char c : "balon".toCharArray()) {
            maxBalloons = Math.min(maxBalloons, freq[c - 'a']);
        }
        return maxBalloons;
    }
}
