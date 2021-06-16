package recursion.solution226;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree_2 {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  public TreeNode invertTree_1(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left != null) {
          queue.add(tmp.left);
        }
        if (tmp.right != null) {
          queue.add(tmp.right);
        }
        TreeNode leftTmp = tmp.left;
        tmp.left = tmp.right;
        tmp.right = leftTmp;
      }
    }
    return root;
  }

}
