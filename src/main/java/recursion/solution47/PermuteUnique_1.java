package recursion.solution47;

import java.util.*;

public class PermuteUnique_1 {
	Deque<Integer> stack = new LinkedList<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Boolean[] visited = new Boolean[nums.length];
		Arrays.fill(visited, false);
		Arrays.sort(nums);
		_dfs(nums, 0, visited);
		return ans;
	}

	private void _dfs(int[] nums, int depth, Boolean[] visited) {
		if (depth == nums.length) {
			ans.add(new ArrayList<>(stack));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			stack.push(nums[i]);
			_dfs(nums, depth + 1, visited);
			stack.pop();
			visited[i] = false;

		}
	}
}
