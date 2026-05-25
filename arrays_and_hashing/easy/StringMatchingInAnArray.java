package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();

        for (String word : words) {
            for (String subWord : words) {

                if (word.length() <= subWord.length()) {
                    continue;
                }
                if (!word.equals(subWord) && word.contains(subWord)) {
                    result.add(subWord);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
