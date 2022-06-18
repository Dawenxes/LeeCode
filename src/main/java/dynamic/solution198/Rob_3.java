package dynamic.solution198;

public class Rob_3 {
  public int rob(int[] nums) {
    int m = nums.length;
    int n = 2;
    int[][] dp = new int[nums.length][2];
    dp[0][0] = 0;
    dp[0][1] = nums[0];
    dp[1][0] = dp[0][1];
    dp[1][1] = dp[0][0] + nums[1];
    for (int i = 2; i < m; i++) {
      dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
    }
    return dp[m - 1][1];
  }
}
