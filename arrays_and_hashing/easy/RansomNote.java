package arrays_and_hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    // Solution 1 with O(n+m) time and O(k) space where
    // m and n are String lengths and k=distinct chars
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charsCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        Map<Character, Integer> wordFreq = new HashMap<>();
        for (int j = 0; j < ransomNote.length(); j++) {
            char c = ransomNote.charAt(j);
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
            if (charsCount.getOrDefault(c, 0) >= wordFreq.get(c)) {
                count++;
            } else {
                break;
            }
        }
        return count == ransomNote.length();
    }

    // Solution 2 using direct decrementing
    public boolean canConstructTwo(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            int available = counts.getOrDefault(c, 0);

            if (available == 0) {
                return false;
            }

            counts.put(c, available - 1);
        }
        return true;
    }

    // Solution 3 using problem constraints
    public boolean canConstructThree(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            // decrements and checks
            if (--counts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
