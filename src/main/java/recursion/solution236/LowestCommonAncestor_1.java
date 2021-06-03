package recursion.solution236;

import common.TreeNode;

public class LowestCommonAncestor_1 {
  TreeNode result = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    _dfs(root, p, q);
    return result;
  }

  private boolean _dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      //
      return false;
    }
    boolean lson = _dfs(root.left, p, q);
    boolean rson = _dfs(root.right, p, q);
    if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
      result = root;
    }
    return (root.val == p.val || root.val == q.val) || (lson || rson);
  }
}
