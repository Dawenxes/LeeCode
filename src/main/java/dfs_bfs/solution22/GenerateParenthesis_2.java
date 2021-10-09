package dfs_bfs.solution22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_2 {
	List<String> ans = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		dfs(0, 0, n, new StringBuilder());
		return ans;
	}

	private void dfs(int left, int right, int n, StringBuilder stringBuilder) {
		if (left == n && right == n) {
			ans.add(stringBuilder.toString());
			return;
		}

		if (left < n) {
			dfs(left + 1, right, n, new StringBuilder(stringBuilder).append("("));
		}
		if (right < left) {
			dfs(left, right + 1, n, new StringBuilder(stringBuilder).append(")"));
		}
	}
}
