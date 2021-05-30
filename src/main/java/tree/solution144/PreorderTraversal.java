package tree.solution144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> integers = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return integers;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    private void visit(TreeNode root) {
        integers.add(root.val);
    }


    Deque<TreeNode> stack = new LinkedList<>();

  public List<Integer> preorderTraversal_1(TreeNode root) {
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        visit(root);
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
    return integers;
  }
}
