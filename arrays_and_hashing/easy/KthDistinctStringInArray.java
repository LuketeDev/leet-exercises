package arrays_and_hashing.easy;

import java.util.HashMap;

public class KthDistinctStringInArray {
    // Solution 1 with O(N) speed
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> freqs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freqs.merge(arr[i], 1, Integer::sum);
        }
        for (String s : arr) {
            if (freqs.get(s) == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        // fewer than k
        return "";
    }
}
