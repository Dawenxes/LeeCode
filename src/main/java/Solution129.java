import common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);

    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val + i * 10;
        if (root.left == null && root.right == null) {
            return tmp;
        } else {
            return dfs(root.left, tmp) + dfs(root.right, tmp);
        }
    }

    public static void main(String[] args) {

    }
}
