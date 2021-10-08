package divide_conquer.solution17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_3 {
	List<String> result = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return result;
		}
		Map<Character, String> phoneMap = new HashMap<Character, String>(16) {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}
		};
		dfs(digits, phoneMap, new StringBuilder());
		return result;
	}

	private void dfs(String digits, Map<Character, String> phoneMap, StringBuilder deque) {
		if (deque.length() == digits.length()) {
			result.add(new String(deque));
			return;
		}
		int length = deque.length();
		char c = digits.charAt(length);
		String s = phoneMap.get(c);
		for (int i = 0; i < s.toCharArray().length; i++) {
			dfs(digits, phoneMap, new StringBuilder(deque).append(s.charAt(i)));
		}
	}

}
