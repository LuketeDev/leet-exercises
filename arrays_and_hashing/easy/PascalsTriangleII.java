package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    // Solution in O(n^2) time and space
    public List<Integer> getRow(int rowIndex) {
        int[][] triangle = new int[rowIndex + 1][];

        for (int i = 0; i <= rowIndex; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int val : triangle[rowIndex]) {
            result.add(val);
        }

        return result;
    }

    // Solution in O(n) space and O(n^2) time
    public List<Integer> getRowTwo(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0, 0);
            for (int j = 0; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    // Solution in O(n) space and time
    public List<Integer> getRowThree(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            long val = (long) row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add((int) val);
        }
        return row;
    }
}
