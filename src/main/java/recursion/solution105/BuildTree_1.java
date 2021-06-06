package recursion.solution105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_1 {
  Map<Integer, Integer> inorderMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(i, inorder[i]);
    }
    int length = preorder.length;
    return _buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
  }

  private TreeNode _buildTree(
      int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
    if (preBegin >= preEnd) {
      return null;
    }
    int preRoot = preorder[preBegin];
    Integer rootPosition = inorderMap.get(preBegin);
    int leftLength = rootPosition - inBegin;
    TreeNode root = new TreeNode(preRoot);
    root.left =
        _buildTree(
            preorder, inorder, preBegin + 1, preBegin + leftLength , inBegin, rootPosition - 1);
    root.right =
        _buildTree(preorder, inorder, preBegin + leftLength+1, preEnd, rootPosition + 1, inEnd);
    return root;
  }
}
