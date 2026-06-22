package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    // Solution 1 with O(n log n) time and O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            anagramsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anagramsMap.values());
    }

    // Solution 2 using chars values sum for O(n*k) time and O(n) space
    // where n = strings and k = max string length
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#'); // separator to avoid ambiguity
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();
            anagramsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}
