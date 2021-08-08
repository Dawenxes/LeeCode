package contest.week253.solution5838;

public class IsPrefixString {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        for (String word : words) {
            int j = 0;
            for (; j < word.length() && i < s.length(); j++) {
                if (word.charAt(j) != s.charAt(i)) {
                    return false;
                }
                i++;
            }
            if (j == word.length() && i == s.length()) {
                return true;
            }
        }
        return false;
    }

}
