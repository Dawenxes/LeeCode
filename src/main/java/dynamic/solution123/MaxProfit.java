package dynamic.solution123;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(buy1 + prices[i], sell1);
            buy2 = Math.max(sell1 - prices[i], buy2);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }
        return sell2;
    }

    public int maxProfit_1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
        }
        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit_1(new int[]{1, 2}));
    }
}
