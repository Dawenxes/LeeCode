package dynamic.solution32;

public class LongestValidParentheses_1 {
    public static void main(String[] args) {
        LongestValidParentheses_1 longestValidParentheses_1 = new LongestValidParentheses_1();
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
        for (int i = 1; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            if (cur == ')' && i > 1) {
                char pre = s.charAt(i - 2);
                if (pre == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 > 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] > 1) ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
