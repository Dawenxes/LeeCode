package dynamic.solution198;

public class Rob_2 {
    public int rob(int[] nums) {
        int m = nums.length;
        int n = 2;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return dp[m - 1][n - 1];
    }
}
