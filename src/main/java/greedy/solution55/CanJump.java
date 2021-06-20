package greedy.solution55;

public class CanJump {
  public boolean canJump(int[] nums) {
    int maxStep = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i <= maxStep) {
        maxStep = Math.max(maxStep, i + nums[i]);
        if (maxStep >= nums.length - 1) {
          return true;
        }
      }
    }
    return false;
  }
}
