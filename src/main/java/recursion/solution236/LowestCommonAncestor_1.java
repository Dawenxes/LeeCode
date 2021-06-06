package recursion.solution236;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }
    TreeNode left = lowestCommonAncestor_1(root.left, p, q);
    TreeNode right = lowestCommonAncestor_1(root.right, p, q);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    return root;
  }

  Map<Integer, TreeNode> parent = new HashMap<>();
  Set<Integer> pParents = new HashSet<>();

  public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
    _dfsVisit(root);
    while (p != null) {
      pParents.add(p.val);
      p = parent.get(p.val);
    }
    while (q != null) {
      if (pParents.contains(q.val)) {
        return q;
      }
      q = parent.get(q.val);
    }
    return null;
  }

  private void _dfsVisit(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      parent.put(root.left.val, root);
      _dfsVisit(root.left);
    }
    if (root.right != null) {
      parent.put(root.right.val, root);
      _dfsVisit(root.right);
    }
  }

}
