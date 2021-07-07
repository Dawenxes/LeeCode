package dynamic.solution221;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] s = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        new MaximalSquare().maximalSquare(s);
    }

    public int maximalSquare(char[][] matrix) {
        int r = matrix.length + 1;
        int c = matrix[0].length + 1;
        int[][] dp = new int[r][c];
        int ans = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                char cc = matrix[i - 1][j - 1];
                if (cc == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j] * dp[i][j], ans);
            }
        }
        return ans;
    }
}
