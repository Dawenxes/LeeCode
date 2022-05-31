package dynamic.solution188;

public class MaxProfit2 {
  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0 || prices.length == 1||k==0) {
      return 0;
    }
    int[][][] dp = new int[prices.length][k][2];
    int length = prices.length;
    for (int i = 0; i < k; i++) {
      dp[0][i][0] = 0;
      dp[0][i][1] = -prices[0];
    }
    for (int i = 1; i < length; i++) {
      for (int j = 0; j < k; j++) {
        if (j==0){
          dp[i][0][1]=Math.max(dp[i-1][0][1],-prices[i]);
          dp[i][0][0]=Math.max(dp[i-1][0][0],dp[i-1][0][1]+prices[i]);
        }else{
          dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
          dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
        }
      }
    }

    return dp[length - 1][k - 1][0];
  }

  public static void main(String[] args) {
    MaxProfit2 maxProfit = new MaxProfit2();
    System.out.println(maxProfit.maxProfit(2, new int[] {1, 2}));
  }
}
