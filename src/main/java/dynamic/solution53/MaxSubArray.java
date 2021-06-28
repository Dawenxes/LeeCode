package dynamic.solution53;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    int ans = Integer.MIN_VALUE;

    public int maxSubArray_1(int[] nums) {
        _dfs(nums, 1, nums[0]);
        return ans;
    }

    private void _dfs(int[] nums, int i, int pre) {
        if (i == nums.length) {
            return;
        }
        ans = Math.max(nums[i] + pre, nums[i]);
        _dfs(nums, i + 1, ans);
    }
}
