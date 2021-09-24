package recursion.solution98;

import java.util.Deque;
import java.util.LinkedList;

import common.TreeNode;

public class IsValidBST_3 {
	public boolean isValidBST(TreeNode root) {
		long pre = Long.MIN_VALUE;
		Deque<TreeNode> stack = new LinkedList<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode pop = stack.pop();
			if (pre >= pop.val) {
				return false;
			}
			pre = pop.val;
			root = pop.right;
		}
		return true;
	}

	public boolean isValidBstRecursion(TreeNode root) {
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean dfs(TreeNode root, long pre, long last) {
		if (root == null) {
			return true;
		}
		if (root.val <= pre || root.val >= last) {
			return false;
		}
		return dfs(root.left, pre, root.val) && dfs(root.right, root.val, last);
	}

}
