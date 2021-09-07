package dynamic.solution32;

public class LongestValidParentheses_2 {
	public static void main(String[] args) {
		LongestValidParentheses_2 longestValidParentheses_1 = new LongestValidParentheses_2();
		System.out.println(longestValidParentheses_1.longestValidParentheses(")()())"));

	}

	public int longestValidParentheses(String s) {
		int ans = 0;
		if (s.length() == 0) {
			return 0;
		}
		// dp为选择i号字符的最长有效括号长度
		int[] dp = new int[s.length() + 1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= s.length(); i++) {
			char ch = s.charAt(i - 1);
			if (ch == ')') {
				char preCh = s.charAt(i - 2);
				if (preCh == '(') {
					dp[i] = dp[i - 2] + 2;
				} else if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
					dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
				}

			}
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
}
