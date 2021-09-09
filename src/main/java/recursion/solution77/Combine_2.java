package recursion.solution77;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine_2 {
	Deque<Integer> stack = new LinkedList<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n < k || k == 0) {
			return ans;
		}
		_dfs(n, k, 1);
		return ans;
	}

	private void _dfs(int n, int k, int begin) {
		if (stack.size() == k) {
			ArrayList<Integer> e = new ArrayList<>(stack);
			ans.add(e);
			return;
		}
		if (k - stack.size() > n - begin + 1) {
			return;
		}

		for (int i = begin; i <= n; i++) {
			stack.push(i);
			_dfs(n, k, i + 1);
			stack.pop();
		}
	}

}
