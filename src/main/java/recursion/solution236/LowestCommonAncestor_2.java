package recursion.solution236;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor_2 {
  TreeNode result = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    _dfs(root, p, q);
    return result;
  }

  private boolean _dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    boolean lson = _dfs(root.left, p, q);
    boolean rson = _dfs(root.right, p, q);
    if ((lson && rson) || ((lson || rson) && (root.val == p.val || root.val == q.val))) {
      result = root;
    }
    return (root.val == p.val || root.val == q.val) || (lson || rson);
  }

  public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }
    TreeNode left = lowestCommonAncestor_1(root.left, p, q);
    TreeNode right = lowestCommonAncestor_1(root.right, p, q);
    if (right == null) {
      return left;
    }
    if (left == null) {
      return right;
    }
    return root;
  }

  Map<Integer, TreeNode> parents = new HashMap<>();
  Set<Integer> visited = new HashSet<>();

  public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
    _dfsVisit(root);
    while (p != null) {
      visited.add(p.val);
      p = this.parents.get(p.val);
    }
    while (q != null) {
      if (visited.contains(q.val)) {
        return q;
      }
      q = this.parents.get(q.val);
    }
    return null;
  }

  private void _dfsVisit(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      parents.put(root.left.val, root);
      _dfsVisit(root.left);
    }
    if (root.right != null) {
      parents.put(root.right.val, root);
      _dfsVisit(root.right);
    }
  }
}
