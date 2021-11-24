package greedy.solution55;

public class CanJump_3 {
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxStep >= i) {
                maxStep = Math.max(i + nums[i], maxStep);
            } else {
                return false;
            }
        }
        return true;
    }
}
