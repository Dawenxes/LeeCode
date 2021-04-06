import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class Solution114 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    void preorder(TreeNode root, List list) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        Solution114 solution75 = new Solution114();

        System.out.println();

    }
}
