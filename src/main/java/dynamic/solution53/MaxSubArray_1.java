package dynamic.solution53;

public class MaxSubArray_1 {
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		int pre = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pre = Math.max(pre + nums[i], nums[i]);
			ans = Math.max(pre, ans);
		}
		return ans;
	}


}
