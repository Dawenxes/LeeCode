package tree.solution145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal_1 {
    List<Integer> integers = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return integers;
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        visit(root);

    }

    private void visit(TreeNode root) {
        integers.add(root.val);
    }


    public List<Integer> postorderTraversal_1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (root.right == null || root.right == pre) {
                visit(root);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return integers;
    }
}
