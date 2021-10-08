package everyday.solution437;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class PathSum {

	public int pathSum(TreeNode root, int targetSum) {

		HashMap<Integer, Integer> pre = new HashMap<>();
		pre.put(0, 1);
		return dfs(root, targetSum, 0, pre);

	}

	private int dfs(TreeNode root, int targetSum, int curSum, Map<Integer, Integer> pre) {
		if (root == null) {
			return 0;
		}
		curSum = curSum + root.val;
		Integer ret = pre.getOrDefault(curSum - targetSum, 0);
		pre.put(curSum, pre.getOrDefault(curSum, 0) + 1);
		ret += dfs(root.left, targetSum, curSum, pre);
		ret += dfs(root.right, targetSum, curSum, pre);
		pre.put(curSum, pre.get(curSum) - 1);
		return ret;
	}
}
