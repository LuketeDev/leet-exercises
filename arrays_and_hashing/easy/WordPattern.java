package arrays_and_hashing.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    // Solution 1 using HashMap with O(n) space and time.
    // Same idea as IsomorphicStrings
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapPS = new HashMap<>();
        Map<String, Character> mapSP = new HashMap<>();
        String[] splitted = s.split(" ");
        if (splitted.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char charP = pattern.charAt(i);
            String wordS = splitted[i];

            if (mapPS.containsKey(charP)) {
                if (!mapPS.get(charP).equals(wordS))
                    return false;
            } else {
                mapPS.put(charP, wordS);
            }
            if (mapSP.containsKey(wordS)) {
                if (mapSP.get(wordS) != charP)
                    return false;
            } else
                mapSP.put(wordS, charP);
        }
        return true;
    }

    // Solution 2 with same complexity using single map
    public boolean wordPatternTwo(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        Map<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            if (!Objects.equals(map.put(c, i), map.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }
}
