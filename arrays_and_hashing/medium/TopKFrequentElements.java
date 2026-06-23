package arrays_and_hashing.medium;

public class TopKFrequentElements {

    // Solution 1 with O(n^2) time and O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        int[] res = new int[k];
        for (int i : nums) {
            freq[i + 1000]++;
        }

        for (int i = 0; i < k; i++) {
            int maxIdx = 0;
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] > freq[maxIdx]) {
                    maxIdx = j;
                }
            }
            res[i] = maxIdx - 1000;
            freq[maxIdx] = -1;
        }
        return res;
    }
}
