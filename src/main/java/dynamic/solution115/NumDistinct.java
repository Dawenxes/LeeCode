package dynamic.solution115;

/**
 * @Description: 不同的子序列
 * @ClassName: NumDistinct
 * @Author: zbn
 * @Date: 2021/8/5 9:45
 */
public class NumDistinct {
    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        System.out.println(numDistinct.numDistinct("dag", "da"));
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[i][j] = 1;
                } else if (i == m) {
                    dp[i][j] = 0;
                } else if (j == n) {
                    dp[i][j] = 1;
                } else {
                    char sChar = s.charAt(i);
                    char tChar = t.charAt(j);
                    if (sChar == tChar) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];

    }
}
