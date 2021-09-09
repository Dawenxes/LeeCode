package recursion.solution46;

import java.util.*;

public class Permute_2 {
	Deque<Integer> stack = new LinkedList<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
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
			if (!visited[i]) {
				visited[i] = true;
				stack.push(nums[i]);
				_dfs(nums, visited);
				stack.pop();
				visited[i] = false;
			}
		}
	}


}
