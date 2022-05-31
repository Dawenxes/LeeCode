package dynamic.solution120;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal2 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] p = new int[n];

    int[] f = new int[n];
    f[0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++) {
      List<Integer> list = triangle.get(i);
      for (int j = 0; j < list.size(); j++) {
        //
        if (j == 0) {
          p[j] = f[0] + list.get(j);
        } else if (j == list.size() - 1) {
          p[j] = f[j - 1] + list.get(j);
        } else {
          p[j] = Math.min(f[j - 1], f[j]) + list.get(j);
        }
      }
      f = p.clone();

      //
    }
    return Arrays.stream(f).min().getAsInt();
  }
}
