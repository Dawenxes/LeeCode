package listlink.solution11;

public class MaxArea_1 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(area, ans);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
