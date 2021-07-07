package dynamic.solution72;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int length = word1.length();
        int length1 = word2.length();
        int[][] dp = new int[length + 1][length1 + 1];
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < length1 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length1 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[length][length1];
    }
}
