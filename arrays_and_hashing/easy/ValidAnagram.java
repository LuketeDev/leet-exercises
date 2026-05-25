package arrays_and_hashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ValidAnagram {
    // Solution 1 with O(N log N)

    public boolean isAnagramOne(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    // Solution 2 using frequency array with O(N)
    public boolean isAnagramTwo(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> count = new HashMap<>();

        for (char c : sChars) {
            count.put(c, count.getOrDefault(c, 0) + 1); // Adds count for a char
        }

        for (char c : tChars) {
            int freq = count.getOrDefault(c, 0);
            if (freq == 0) // If char not in sChars
                return false;
            count.put(c, freq - 1); // Subtract count for the char
        }
        return true;
    }

    // Solution 3 accepting unicode, using frequency array, with O(N)
    public boolean isAnagramThree(String s, String t) {
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length()))
            return false;

        Map<Integer, Integer> count = new HashMap<>();
        s.codePoints().forEach(cp -> count.put(cp, count.getOrDefault(cp, 0) + 1));

        for (int cp : t.codePoints().toArray()) {
            int freq = count.getOrDefault(cp, 0);
            if (freq == 0)
                return false;
            count.put(cp, freq - 1);
        }
        return true;
    }

}
