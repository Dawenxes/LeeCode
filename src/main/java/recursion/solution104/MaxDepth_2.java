package recursion.solution104;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * @author 张博能
 */
public class MaxDepth_2 {
	public int maxDepth(TreeNode root) {
		int ans = 0;
		if (root == null) {
			return ans;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	public int maxDepth1(TreeNode root) {
		int ans = 0;
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			ans++;
		}
		return ans;
	}
}
