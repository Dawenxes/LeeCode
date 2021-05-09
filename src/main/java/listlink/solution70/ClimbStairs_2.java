package listlink.solution70;

public class ClimbStairs_2 {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else {
      int pre = 2, pre_pre = 1;
      int ans = 0;
      for (int i = 3; i <= n; i++) {
        ans = pre + pre_pre;
        pre_pre = pre;
        pre = ans;
      }
      return ans;
    }
  }
}
