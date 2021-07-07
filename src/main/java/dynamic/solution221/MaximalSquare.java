package dynamic.solution221;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] =
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                dp[i][j] = dp[]
            }
        }
        return dp[r][c];
    }
}
