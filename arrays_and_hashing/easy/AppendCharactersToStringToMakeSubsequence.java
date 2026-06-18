package arrays_and_hashing.easy;

public class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int j = 0;

        for (char ch : s.toCharArray()) {
            if (j < t.length() && ch == t.charAt(j)) {
                j++;
            }
        }
        return t.length() - j;
    }
}
