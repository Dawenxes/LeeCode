package listlink.solution11;

public class MaxArea_3 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, (Math.min(height[left], height[right]) * (right - left)));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
