package dynamic.solution746;

/**
 * @Description: 使用最小花费爬楼梯
 * @ClassName: MinCostClimbingStairs
 * @Author: zbn
 * @Date: 2021/8/3 10:34
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int m = cost.length;
        int n = 2;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        dp[0][1] = cost[0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i];
        }
        return Math.min(dp[m - 1][0], dp[m - 1][1]);
    }
}
