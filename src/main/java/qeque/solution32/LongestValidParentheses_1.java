package qeque.solution32;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses_1 {
	public static void main(String[] args) {
		System.out.println(new LongestValidParentheses_1().longestValidParentheses(")()())"));
	}

	public int longestValidParentheses(String s) {
		Deque<Integer> stack = new LinkedList<>();
		stack.push(-1);
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					ans = Math.max(ans, i - stack.peek());
				}
			}
		}
		return ans;
	}
}
