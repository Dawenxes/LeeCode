package dynamic.solution518;

public class Change {
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] += dp[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * val];
                }
            }
        }
        return dp[n][amount];
    }

    public int change_1(int amount, int[] coins) {
        int n = coins.length + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int val = coins[i - 1];
            for (int j = val; j < amount + 1; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Change coinChange = new Change();
        System.out.println(coinChange.change(5, new int[]{1, 2, 5}));
    }
}
