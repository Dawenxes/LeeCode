package dynamic.solution63;

/**
 * @author ZhangBoneng
 */
public class UniquePathsWithObstacles_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (i == 0 && j != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (i != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
