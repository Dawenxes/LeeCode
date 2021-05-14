package listlink.solution70;

public class ClimbStairs_3 {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    int f1 = 1, f2 = 2;
    int ans=0;
    for (int i = 3; i <= n; i++) {
      ans = f1 + f2;
      f1 = f2;
      f2 = ans;
    }
    return ans;
  }
}
