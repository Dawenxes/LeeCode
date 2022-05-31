package dynamic.solution115;

/**
 * @Description: 不同的子序列 @ClassName: NumDistinct @Author: zbn @Date: 2021/8/5 9:45
 */
public class NumDistinct2 {
  public static void main(String[] args) {
    NumDistinct2 numDistinct = new NumDistinct2();
    System.out.println(numDistinct.numDistinct("dag", "da"));
  }

  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    if (m < n) {
      return 0;
    }
    char[] sch = s.toCharArray();
    char[] tch = t.toCharArray();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <=m; i++) {
      for (int j = 0; j <= n; j++) {
        if (j == 0) {
          dp[i][j] = 1;
        } else if (i == 0) {
          dp[i][j] = 0;
        } else {
          if (sch[i - 1] == tch[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
    }
    return dp[m][n];
  }
}
