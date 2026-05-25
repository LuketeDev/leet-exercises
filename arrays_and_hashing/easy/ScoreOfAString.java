package arrays_and_hashing.easy;

public class ScoreOfAString {
    public int scoreOfString(String s) {
        int[] arrAscii = s.chars().toArray();
        int res = 0;
        for (int i = 0; i < arrAscii.length - 1; i++) {
            int sum = Math.abs(arrAscii[i] - arrAscii[i + 1]);
            res += sum;
        }
        return res;
    }
}
