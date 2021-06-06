package recursion.solution46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute_1 {
  Deque<Integer> stack = new LinkedList<>();
  List<List<Integer>> ans = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
    Boolean[] visited = new Boolean[nums.length];
    Arrays.fill(visited, false);
    _dfs(nums, 0,visited);
    return ans;
  }

  private void _dfs(int[] nums, int depth, Boolean[] visited) {
    if (depth == nums.length) {
      ans.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        stack.push(nums[i]);
        _dfs(nums, depth + 1, visited);
        stack.pop();
        visited[i] = false;
      }
    }
  }
}
