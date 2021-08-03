package dynamic.solution64;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] dp = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[c - 1];
    }
}
