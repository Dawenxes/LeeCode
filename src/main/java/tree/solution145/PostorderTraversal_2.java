package tree.solution145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class PostorderTraversal_2 {
	List<Integer> integers = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		root.right = root1;
		root1.left = root2;
		PostorderTraversal_2 postorderTraversal_2 = new PostorderTraversal_2();

		System.out.println(postorderTraversal_2.postorderTraversal(root));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode peek = stack.peek();
			if (peek.right != null && peek.right != pre) {
				root = peek.right;
			} else {
				pre = peek;
				TreeNode pop = stack.pop();
				visit(pop);
			}
		}
		return integers;
	}

	private void visit(TreeNode root) {
		integers.add(root.val);
	}
}
