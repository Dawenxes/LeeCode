package recursion.solution77;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine_1 {
  Deque<Integer> stack = new LinkedList<>();
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    if (n < k || k == 0) {
      return ans;
    }
    _dfs(n, k, 0);
    return ans;
  }

  private void _dfs(int n, int k, int begin) {
    if (stack.size() == k) {
      ans.add(new ArrayList<>(stack));
      return;
    }
    for (int i = begin; i <= n; i++) {
      stack.push(i);
      _dfs(n, k, i + 1);
      stack.pop();
    }
  }

}
