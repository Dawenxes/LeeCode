package dynamic.solution120;

import java.util.List;

public class MinimumTotal {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] f = new int[n][n];
    f[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> list = triangle.get(i);
      f[i][0] = f[i - 1][0] + list.get(0);
      for (int j = 1; j < i; j++) {
        f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + list.get(j);
      }
      f[i][i] = f[i - 1][i - 1] + list.get(i);
      //
    }
    int ans = f[n - 1][0];
    for (int i = 1; i < n; i++) {
      //
      ans = Math.min(ans, f[n - 1][i]);
    }
    return ans;
  }
}
