package arrays_and_hashing.easy;

public class CanPlaceFlowers {
    // Solution 1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if ((flowerbed.length == 1 && flowerbed[0] == 0)
                || (flowerbed.length == 2 && flowerbed[0] == 0 && flowerbed[1] == 0)) {
            return true;
        }

        if (flowerbed.length >= 3) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (i == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i >= 1 && i <= flowerbed.length - 2 && flowerbed[i] == 0
                        && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }

                else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

    // Clean solution 2
    public boolean canPlaceFlowersTwo(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            // if its the first place
            if (flowerbed[i] == 0) {
                // get number to the left / NPE = 0
                int left = (i == 0) ? 0 : flowerbed[i - 1];

                // get number to the right / NPE = 0
                int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                // no number to left and right or both are 0
                if (left == 0 && right == 0) {
                    // place a flower
                    flowerbed[i] = 1;
                    n--;

                    // no flowers left
                    if (n == 0)
                        return true;
                }
            }
        }
        return n <= 0;
    }
}
