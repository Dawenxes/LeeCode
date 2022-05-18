package recursion.solution106;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangBoneng
 * @version 1.0.0 @ClassName BuildTree @Description TODO
 * @createTime 2022年05月12日 16:54:00
 */
public class BuildTree {
  Map<Integer, Integer> map = new HashMap<>();
  int[] in;
  int[] post;
  int postdx;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    in = inorder;
    post = postorder;
    postdx = postorder.length - 1;
    for (int i = 0; i < postorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(0, postorder.length - 1);
  }

  public TreeNode helper(int left, int right) {
    if (left > right) {
      return null;
    }
    int root = post[postdx];
    TreeNode treeNode = new TreeNode(root);
    Integer index = map.get(root);
    postdx--;
    treeNode.right = helper(index + 1, right);
    treeNode.left = helper(left, index - 1);

    return treeNode;
  }
}
