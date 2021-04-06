/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class Solution530 {
    int tmp = -1;// 存前驱节点
    int result = Integer.MAX_VALUE;// 村结果

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        result = Integer.MAX_VALUE;
        tmp = -1;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (tmp == -1) {
            tmp = root.val;
        } else {
            result = Math.min(result, root.val - tmp);
            tmp = root.val;
        }
        dfs(root.right);
    }


    public static void main(String[] args) {
        int[] s = { 1, 2, 3 };
        Solution530 solution344 = new Solution530();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(12);

        int b = solution344.getMinimumDifference(treeNode);
        System.out.println(b);
    }
}
