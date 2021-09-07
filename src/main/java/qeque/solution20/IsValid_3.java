package qeque.solution20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid_3 {
	public boolean isValid(String s) {
		Deque<Character> characters = new LinkedList<>();
		Map<Character, Character> pairs = new HashMap<Character, Character>() {
			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (pairs.containsKey(ch)) {
				Character pop = characters.pop();
				if (!pairs.get(ch).equals(pop)) {
					return false;
				}
			} else {
				characters.push(ch);
			}
		}

		return characters.isEmpty();
	}
}
