package listlink.solution11;

public class MaxArea_5 {
	public int maxArea(int[] height) {
		int ans = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			} else {
				right++;
			}
		}
		return ans;
	}
}
