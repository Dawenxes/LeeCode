package dynamic.solution32;

public class LongestValidParentheses_3 {
    public static void main(String[] args) {
        LongestValidParentheses_3 longestValidParentheses_1 = new LongestValidParentheses_3();
        System.out.println(longestValidParentheses_1.longestValidParentheses("()(())"));
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        int n = s.length();
        if (n == 0 || n == 1) {
            return ans;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i > (dp[i - 1]) && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i > (dp[i - 1] + 1) ? dp[i - dp[i - 1] - 2] : 0) + 2 + dp[i - 1];
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
