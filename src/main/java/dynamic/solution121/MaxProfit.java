package dynamic.solution121;

public class MaxProfit {
    public int maxProfit_1(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i - 1], min);
            ans = Math.max(prices[i] - min, ans);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{1, 2}));
    }
}
