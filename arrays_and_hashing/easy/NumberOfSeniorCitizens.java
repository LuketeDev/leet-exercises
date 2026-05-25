package arrays_and_hashing.easy;

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int seniors = 0;
        for (String citizen : details) {
            String ageStr = citizen.substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                seniors++;
            }

        }
        return seniors;
    }
}
