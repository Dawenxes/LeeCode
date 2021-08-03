package dynamic.solution300;

/**
 * @Description: 最长递增子序列
 * @ClassName: LengthOfLIS
 * @Author: zbn
 * @Date: 2021/8/3 11:19
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(dp[i], maxans);
        }
        return maxans;
    }
}
