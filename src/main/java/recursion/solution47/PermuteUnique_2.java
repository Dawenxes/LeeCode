package recursion.solution47;

import java.util.*;

public class PermuteUnique_2 {
    Deque<Integer> stack = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Boolean[] visited = new Boolean[nums.length];
        Arrays.fill(visited, false);
        _dfs(nums, visited);
        return ans;
    }

    private void _dfs(int[] nums, Boolean[] visited) {
        if (stack.size() == nums.length) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            stack.push(nums[i]);
            visited[i] = true;
            _dfs(nums, visited);
            visited[i] = false;
            stack.pop();
        }
    }
}
