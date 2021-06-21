package divide_conquer.solution17;

import java.util.*;

public class LetterCombinations_2 {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        _dfs(phoneMap, digits, new StringBuilder());

        return result;
    }

    private void _dfs(Map<Character, String> phoneMap, String digits, StringBuilder tmp) {
        if (tmp.length() == digits.length()) {
            result.add(new String(tmp));
            return;
        }
        int k = tmp.length();
        String str = phoneMap.get(digits.charAt(k));
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            _dfs(phoneMap, digits, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
