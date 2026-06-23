package arrays_and_hashing.medium;

public class AverageWaitingTime {
    // Solution 1 with O(n) time and O(1) space
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0;
        long currTime = 0;
        for (int[] customer : customers) {
            int arrival = customer[0];
            int prepTime = customer[1];

            currTime = Math.max(currTime, arrival);
            currTime += prepTime;

            totalWait += currTime - arrival;
        }
        return (double) totalWait / customers.length;
    }
}
