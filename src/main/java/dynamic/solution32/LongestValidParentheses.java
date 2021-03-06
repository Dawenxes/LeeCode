package dynamic.solution32;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int ans = 0;
        if(s.length()==0){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
