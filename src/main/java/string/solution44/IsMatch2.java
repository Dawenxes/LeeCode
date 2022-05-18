package string.solution44;

/**
 * @Description: 通配符匹配 @ClassName: IsMatch @Author: zbn @Date: 2021/8/16 10:55
 */
public class IsMatch2 {
  public static void main(String[] args) {
    IsMatch2 isMatch = new IsMatch2();
    System.out.println(isMatch.isMatch("aab", "a*b"));
  }

  // 动态规划
  private boolean isMatch(String str, String pattrn) {
    int m = str.length();
    int n = pattrn.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char p = pattrn.charAt(j - 1);
        if (p == '*') {
          dp[i][j] = dp[i][j - 2];
          char pre = pattrn.charAt(j - 2);
          if (i > 0 && (pre == '.' || pre == (str.charAt(i - 1)))) {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        } else {
          if (i == 0) {
            dp[i][j] = false;
            continue;
          }
          if (p == '.' || p == (str.charAt(i - 1))) {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = false;
          }
        }
      }
    }
    return dp[m][n];
  }
}
