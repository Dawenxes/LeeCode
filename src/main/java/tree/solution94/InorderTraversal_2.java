package tree.solution94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_2 {
    List<Integer> integers = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        _inorder(root);
        return integers;
    }

    private void _inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        _inorder(root.left);
        visit(root);
        _inorder(root.right);

    }


    private void visit(TreeNode root) {
        integers.add(root.val);
    }


    Deque<TreeNode> stack = new LinkedList<>();

    public List<Integer> inorderTraversal_1(TreeNode root) {
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            visit(root);
            root = root.right;
        }
        return integers;
    }
}
