package arrays_and_hashing.easy;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        int[][] triangle = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            // adds a row filled with zeros
            triangle[i] = new int[i + 1];
            // sets leftmost and rightmost (edges) to 1
            triangle[i][0] = triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                // hexagon = left hexagon from top row + right hexagon from top row
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return Arrays.stream(triangle).map(inner -> Arrays.stream(inner).boxed().toList()).toList();

    }
}
