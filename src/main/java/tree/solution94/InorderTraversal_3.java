package tree.solution94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class InorderTraversal_3 {
	List<Integer> integers = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();


	public List<Integer> inorderTraversal(TreeNode root) {
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode pop = stack.pop();
			visit(pop);
			root = pop.right;
		}
		return integers;
	}

	private void visit(TreeNode root) {
		integers.add(root.val);
	}
}
