package dynamic.solution152;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int imin = nums[0];
        int imax = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = imax, mi = imin;
            imin = Math.min(Math.min(mi * nums[i], nums[i]), mx * nums[i]);
            imax = Math.max(Math.max(mx * nums[i], nums[i]), mi * nums[i]);
            ans = Math.max(ans, imax);
        }
        return ans;
    }
}
