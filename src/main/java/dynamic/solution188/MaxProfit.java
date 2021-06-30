package dynamic.solution188;

public class MaxProfit {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[n][2 * k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = -prices[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else if (j > 0 && j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + prices[i]);
                }
            }
        }
        return dp[n - 1][2 * k - 1];

    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(2, new int[]{1, 2}));
    }
}
