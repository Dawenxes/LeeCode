package dynamic.solution72;

public class MinDistance_3 {
    public int minDistance(String word1, String word2) {
        int length = word1.length();
        int length1 = word2.length();
        int[][] dp = new int[length + 1][length1 + 1];
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < length1 + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    char ch1 = word1.charAt(i - 1);
                    char ch2 = word2.charAt(j - 1);
                    if (ch2 == ch1) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[length][length1];
    }
}
