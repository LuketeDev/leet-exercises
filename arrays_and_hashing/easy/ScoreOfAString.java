package arrays_and_hashing.easy;

public class ScoreOfAString {
    // Solution 1 with O(N) speed and memory
    public int scoreOfString(String s) {
        // Casting a char to an int returns it's ASCII value
        int[] arrAscii = s.chars().toArray();
        int res = 0;
        for (int i = 0; i < arrAscii.length - 1; i++) {
            int sum = Math.abs(arrAscii[i] - arrAscii[i + 1]);
            res += sum;
        }
        return res;
    }

    // Solution 2 with O(1) memory
    public int scoreOfStringTwo(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            // No need to cast, mathematical operators already consider ASCII
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
