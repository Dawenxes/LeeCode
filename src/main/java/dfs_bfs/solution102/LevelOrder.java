package dfs_bfs.solution102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
