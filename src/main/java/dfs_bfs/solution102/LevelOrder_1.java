package dfs_bfs.solution102;

import common.TreeNode;

import java.util.*;

public class LevelOrder_1 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        _dfs(root, 0);
        return ans;
    }

    private void _dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (ans.size() <= i) {
            ans.add(i, new ArrayList<>());
        }
        List<Integer> list = ans.get(i);
        list.add(root.val);
        _dfs(root.left, i + 1);
        _dfs(root.right, i + 1);
    }
}
