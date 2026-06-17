package arrays_and_hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    // Solution using 2 frequency maps with O(n^2) time
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsCount = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            Map<Character, Integer> wordFreq = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
                if (charsCount.getOrDefault(c, 0) >= wordFreq.get(c)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == words[i].length()) {
                sum += count;
            }
        }
        return sum;
    }
}