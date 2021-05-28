package tree.solution144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> integers = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return integers;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        visit(root);
        inorder(root.right);
    }

    private void visit(TreeNode root) {
        integers.add(root.val);
    }


    Deque<TreeNode> stack = new LinkedList<>();

    public List<Integer> inorderTraversal_1(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
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
