package dynamic.solution123;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MaxProfit2 {

  public int maxProfit_1(int[] prices) {
    int n = prices.length;
    //
    int[][][] dp = new int[n][2][2];
    // 第0天第0次交易没有持有股票
    dp[0][0][1] = -prices[0];
    dp[0][0][0] = 0;
    dp[0][1][1] = -prices[0];
    dp[0][1][0] = 0;

    for (int i = 1; i < n; i++) {
      dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
      dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i]);
      dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
      dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
    }

    return dp[n - 1][1][0];
  }

  public static void main(String[] args) {
    MaxProfit2 maxProfit = new MaxProfit2();
    System.out.println(maxProfit.maxProfit_1(new int[] {1, 2}));
  }
}
