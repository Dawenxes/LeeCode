package recursion.solution104;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

  public int maxDepth_1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll(); //
        if (tmp.left != null) {
          queue.add(tmp.left);
        }
        if (tmp.right != null) {
          queue.add(tmp.right);
        }
      }
      ans += 1;
    }
    return ans;
  }
}
