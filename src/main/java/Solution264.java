/** 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 */
public class Solution264 {
  public int nthUglyNumber(int n) {
    int p2 = 1, p3 = 1, p5 = 1;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
      dp[i] = Math.min(Math.min(num2, num3), num5);
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Solution264 solution75 = new Solution264();
    System.out.println(solution75.nthUglyNumber(12));
  }
}
