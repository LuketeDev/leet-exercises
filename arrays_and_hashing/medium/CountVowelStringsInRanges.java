package arrays_and_hashing.medium;

import java.util.List;

public class CountVowelStringsInRanges {
    // Solution 1 with O(n^2) time and O(n) space
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int[] counts = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            int queryCount = 0;
            for (int i = query[0]; i <= query[1]; i++) {
                if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                    queryCount++;
                }
            }
            counts[j] += queryCount;

        }
        return counts;
    }

    // Solution 2 with O(n) time and O(n) space
    public int[] vowelStringsTwo(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String word = words[i];

            boolean valid = isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
            prefix[i + 1] = prefix[i] + (valid ? 1 : 0);
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            res[i] = prefix[right + 1] - prefix[left];
        }

        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }
}
