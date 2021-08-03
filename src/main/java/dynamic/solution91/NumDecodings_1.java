package dynamic.solution91;

public class NumDecodings_1 {
    public static void main(String[] args) {
        NumDecodings_1 solution75 = new NumDecodings_1();
        System.out.println(solution75.numDecodings("2611055971756562"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c == '0') {
                if (c2 == '1' || c2 == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if ((c2 == '2' && c <= '6' && c >= '1') || c2 == '1') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
