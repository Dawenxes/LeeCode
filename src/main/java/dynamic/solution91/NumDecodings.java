package dynamic.solution91;

public class NumDecodings {
    public static void main(String[] args) {
        NumDecodings solution75 = new NumDecodings();
        System.out.println(solution75.numDecodings("2101"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c == '0') {
                if (c2 == '1' || c2 == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = 0;
                }
            } else if (c2 == '1' || (c2 == '2' && c <= '6' && c > '0')) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
