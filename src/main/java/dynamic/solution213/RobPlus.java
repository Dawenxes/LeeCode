package dynamic.solution213;

public class RobPlus {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) {
            return nums[start];
        }
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i+start], dp[i - 1]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        RobPlus robPlus = new RobPlus();
        System.out.println(robPlus.rob(new int[]{1, 2, 3, 1}));
    }
}
