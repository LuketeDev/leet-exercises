package arrays_and_hashing.easy;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int maxVal = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxVal;
            maxVal = Math.max(maxVal, current);
        }
        return arr;
    }
}
