package dynamic.solution312;

/**
 * @Description:戳气球
 * @ClassName: MaxCoins
 * @Author: zbn
 * @Date: 2021/7/13 12:57
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int tmp = arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], tmp);
                }
            }
        }
        return dp[0][n + 1];
    }

}
