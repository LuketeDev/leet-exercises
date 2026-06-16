package arrays_and_hashing.easy;

public class FindLuckyIntegerInAnArray {
    // Solution with O(n+500) time and O(1) space
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        int largest = -1;
        for (int i : arr) {
            freq[i]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == i) {
                largest = Math.max(largest, i);
            }
        }
        return largest;
    }
}
