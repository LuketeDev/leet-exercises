package arrays_and_hashing.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    // Solution 1 with O(n) time and space
    public String destCity(List<List<String>> paths) {
        Set<String> origins = new HashSet<>();
        for (List<String> path : paths) {
            origins.add(path.get(0));
        }

        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!origins.contains(destination)) {
                return destination;
            }
        }
        return "";
    }
}
