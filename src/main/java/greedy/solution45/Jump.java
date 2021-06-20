package greedy.solution45;

public class Jump {
  public int jump(int[] nums) {
    int ans = 0;
    int end = 0;
    int maxSteps = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (i <= maxSteps) {
        maxSteps = Math.max(maxSteps, i + nums[i]);
        if (i == end) {
          ans++;
          end = maxSteps;
        }
      } else {
        return -1;
      }
    }
    return ans;
  }
}
