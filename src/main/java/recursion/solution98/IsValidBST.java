package recursion.solution98;

import java.util.Deque;
import java.util.LinkedList;

import common.TreeNode;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean _isValidBST(TreeNode root, long left, long right) {
		if (root == null) {
			return true;
		}
		if (root.val <= left || root.val >= right) {
			return false;
		}
		return _isValidBST(root.left, left, root.val) && _isValidBST(root.right, root.val, right);
	}

	public boolean isValidBST_1(TreeNode root) {
		long inorder = Long.MAX_VALUE;
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val <= inorder) {
				return false;
			}
			inorder = root.val;
			root = root.right;
		}
		return true;
	}
}
