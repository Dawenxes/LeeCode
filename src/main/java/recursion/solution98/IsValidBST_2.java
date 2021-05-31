package recursion.solution98;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST_2 {
  public boolean isValidBST(TreeNode root) {
    return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean _isValidBST(TreeNode root, long minValue, long maxValue) {
    if (root == null) {
      return true;
    }
    if (root.val <= maxValue || root.val >= maxValue) {
      return false;
    }
    return _isValidBST(root.left, minValue, root.val)
        && _isValidBST(root.right, root.val, maxValue);
  }

  public boolean isValidBST_2(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    long inorderVal = Long.MIN_VALUE;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();

      if (root.val < inorderVal) {
        return false;
      }
      inorderVal = root.val;
      root = root.right;
    }
    return true;
  }
}
