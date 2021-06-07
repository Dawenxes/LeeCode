package tree.solution144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal_1 {
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
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
                visit(root);
            }
            root = stack.pop();
            root = root.right;
        }
        return integers;
    }
    public List<Integer> lastOrderTraversal_1(TreeNode root) {
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return integers;
    }
}
