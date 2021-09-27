package recursion.solution111;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class MinDepth_3 {

	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		treeNode1.right = treeNode2;
		treeNode1.left = treeNode3;
		treeNode2.right = treeNode4;
		MinDepth_3 minDepth_3 = new MinDepth_3();
		System.out.println(minDepth_3.minDepth(treeNode1));

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return 0;
	}
}
