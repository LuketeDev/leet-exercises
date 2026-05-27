package arrays_and_hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    // Solution 1 using hashmap with O(N) space and time.
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT)
                    return false;
            } else {
                mapST.put(charS, charT);
            }
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS)
                    return false;
            } else
                mapTS.put(charT, charS);
        }
        return true;
    }

    // Solution 2 using ASCII array with O(1) space and O(N) speed
    public boolean isIsomorphicTwo(String s, String t) {
        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (lastSeenS[s.charAt(i)] != lastSeenT[t.charAt(i)]) {
                return false;
            }
            lastSeenS[s.charAt(i)] = i + 1;
            lastSeenT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
