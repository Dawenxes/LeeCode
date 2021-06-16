package recursion.solution111;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_2 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int depth = Integer.MAX_VALUE;
    if (root.left != null) {
      depth = Math.min(minDepth(root.left), depth);
    }
    if (root.right != null) {
      depth = Math.min(minDepth(root.right), depth);
    }
    return depth + 1;
  }
  class QueueNode {
    TreeNode node;
    int depth;

    public QueueNode(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }


  public int minDepth_1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int step = 0;
    while (!queue.isEmpty()) {
      step++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node= queue.remove();
        if (node.left == null && node.right == null) {
          return step;
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
