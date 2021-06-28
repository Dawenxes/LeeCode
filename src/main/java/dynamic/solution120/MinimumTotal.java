package dynamic.solution120;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] p = new int[n];

        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        p = f.clone();

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            f[0] = p[0] + list.get(0);
            for (int j = 1; j < i; j++) {
                f[j] = Math.min(p[j - 1], p[j]) + list.get(j);
            }
            f[i] = p[i - 1] + list.get(i);
            p = f.clone();
        }
        int ans = f[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, f[i]);
        }
        return ans;
    }
}
