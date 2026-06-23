package arrays_and_hashing.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathCrossing {
    // Solution 1 with O(n^2) time and O(n) space
    public boolean isPathCrossing(String path) {
        List<int[]> visited = new ArrayList<>();
        int[] curr = { 0, 0 };
        visited.add(curr.clone());

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    curr[0]++;
                    break;
                case 'S':
                    curr[0]--;
                    break;
                case 'E':
                    curr[1]++;
                    break;
                case 'W':
                    curr[1]--;
                    break;
                default:
                    break;
            }
            if (visited.stream().anyMatch(j -> j[0] == curr[0] && j[1] == curr[1]))
                return true;
            visited.add(curr.clone());
        }
        return false;
    }

    // Solution 2 using hashset with O(n) time
    public boolean isPathCrossingTwo(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        visited.add("0,0");
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N' -> y++;
                case 'S' -> y--;
                case 'E' -> x++;
                case 'W' -> x--;
            }

            String pos = x + "," + y;

            if (!visited.add(pos)) {
                return true;
            }
        }
        return false;
    }
}
