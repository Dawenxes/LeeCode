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

  public int jump1(int[] nums) {
    int n = nums.length;
    int[] f = new int[n];
    for (int i = 1, j = 0; i < n; i++) {
      while (j + nums[j] < i) {
        j++;
      }
      f[i] = f[j] + 1;
    }
    return f[n - 1];
  }

  public static void main(String[] args) {
    Jump jump = new Jump();
    System.out.println(jump.jump1(new int[]{1, 0, 0, 0, 0, 0}));
  }
}
