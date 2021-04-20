import common.TreeNode;

public class Solution783 {
  int ans = Integer.MAX_VALUE;
  int pre = -1;

  public int minDiffInBST(TreeNode root) {
    dns(root);
    return ans;
  }

  private void dns(TreeNode root) {
    if (root == null) {
      return;
    }
    dns(root.left);
    if (pre == -1) {
      pre = root.val;
    } else {
      ans = Math.min(root.val - pre, ans);
      pre = root.val;
    }
    dns(root.right);
  }

  public static void main(String[] args) {
    Solution783 solution75 = new Solution783();
  }
}
