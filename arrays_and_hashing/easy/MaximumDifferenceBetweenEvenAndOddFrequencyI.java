package arrays_and_hashing.easy;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    // Speed O(n)
    public int maxDifference(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            // if c == 'a' then c-'a' == 0
            count[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int freq : count) {
            if (freq == 0)
                continue;

            if (freq % 2 == 0) {
                minEven = Math.min(freq, minEven);
            } else {
                maxOdd = Math.max(freq, maxOdd);
            }
        }
        return maxOdd - minEven;
    }
}
