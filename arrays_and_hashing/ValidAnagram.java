package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ValidAnagram {
    // Solution 1 with O(N log N)

    public static boolean isAnagramOne(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    // Solution 2 using frequency array with O(N)
    public static boolean isAnagramTwo(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] count = new int[127]; // ASCII table limit
        for (char c : sChars) {
            count[c]++; // Adds count to a seen char
        }
        for (char c : tChars) {
            count[c]--; // Removes count of a seen char
        }
        // count of each character
        for (int i : count) {
            // sChars has a character not in tChars
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
