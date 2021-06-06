package recursion.solution77;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine {
  Deque<Integer> stack = new LinkedList<>();
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    if (n < k || k <= 0) {
      return null;
    }
    _dfs(n, k, 1);
    return ans;
  }

  private void _dfs(int n, int k, int begin) {
    if (stack.size() == k) {
      ans.add(new ArrayList<>(stack));
      return;
    }

    for (int i = begin; i <= n - k + 1; i++) {
      stack.push(i);
      _dfs(n, k, begin + 1);
      stack.pop();
    }
  }

  private void _dfs1(int n, int k, int begin) {
    if (k == 0) {
      ans.add(new ArrayList<>(stack));
      return;
    }
    if(begin>n-k+1) return;
    _dfs1(n, k, begin + 1);
    stack.push(begin);
    _dfs1(n, k - 1, begin + 1);
    stack.pop();
  }
}
