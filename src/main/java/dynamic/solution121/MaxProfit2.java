package dynamic.solution121;

public class MaxProfit2 {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    int ans = 0;
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return Math.max(dp[n - 1][0], dp[n - 1][1]);
  }

  public static void main(String[] args) {
    MaxProfit2 maxProfit = new MaxProfit2();
    System.out.println(maxProfit.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }
}
