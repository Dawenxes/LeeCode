package recursion.solution46;

import java.util.*;

public class Permute_3 {
	Deque<Integer> stack = new LinkedList<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		Boolean[] visited = new Boolean[nums.length];
		Arrays.fill(visited, false);
		dfs(nums, visited);
		return ans;
	}

	private void dfs(int[] nums, Boolean[] visited) {
		if (stack.size() == nums.length) {
			List<Integer> objects = new ArrayList<>(stack);
			ans.add(objects);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(nums[i]);

				dfs(nums, visited);
				visited[i] = false;
				stack.pop();
			}
		}
	}


}
