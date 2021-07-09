package dynamic.solution410;

import java.util.Arrays;

/**
 * @Description: 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小
 * @ClassName: SplitArray
 * @Author: zbn
 * @Date: 2021/7/9 13:55
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m + 1];
        int[] sub = new int[nums.length + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        for (int i = 1; i < nums.length + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 1; j < Math.min(m + 1, i); j++) {
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[nums.length][m];
    }

}
