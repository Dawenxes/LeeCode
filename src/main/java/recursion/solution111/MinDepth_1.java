package recursion.solution111;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_1 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else if (root.right != null && root.left == null) {
			return minDepth(root.right) + 1;
		} else {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}

	public int minDepth_1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<QueueNode> queue = new LinkedList<>();
		queue.add(new QueueNode(root, 1));
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				QueueNode tmp = queue.remove();
				if (tmp.node.left == null && tmp.node.right == null) {
					return tmp.node.val;
				}
				if (tmp.node.left != null) {
					queue.add(new QueueNode(tmp.node.left, tmp.depth + 1));
				}
				if (tmp.node.right != null) {
					queue.add(new QueueNode(tmp.node.right, tmp.depth + 1));
				}
			}
		}
		return 0;
	}

	class QueueNode {
		TreeNode node;
		int depth;

		public QueueNode(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

}
