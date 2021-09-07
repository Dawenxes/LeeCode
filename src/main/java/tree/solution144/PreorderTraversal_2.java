package tree.solution144;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class PreorderTraversal_2 {
	List<Integer> integers = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();

	public List<Integer> preorderTraversal(TreeNode root) {
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				visit(root);
				stack.push(root);
				root = root.left;
			}
			TreeNode pop = stack.pop();
			root = pop.right;

		}
		return integers;
	}

	private void visit(TreeNode root) {
		integers.add(root.val);
	}
}
