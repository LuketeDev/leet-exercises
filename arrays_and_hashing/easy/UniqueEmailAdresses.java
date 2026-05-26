package arrays_and_hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAdresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniques = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];
            int plusIndex = local.indexOf('+');
            // local contains +
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");
            String normalized = local + domain;
            uniques.add(normalized);
        }
        return uniques.size();
    }
}
