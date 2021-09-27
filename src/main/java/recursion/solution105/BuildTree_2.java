package recursion.solution105;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class BuildTree_2 {
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int length = preorder.length;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return _buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);

	}

	private TreeNode _buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preLeft]);
		// 拿根节点中序遍历的位置
		int inRootPosition = map.get(preorder[preLeft]);
		// 拿左子树的长度
		int leftSonLength = inRootPosition - inLeft;
		root.left = _buildTree(preorder, inorder, preLeft + 1, preLeft + leftSonLength, inLeft, inRootPosition - 1);
		root.right = _buildTree(preorder, inorder, preLeft + leftSonLength + 1, preRight, inRootPosition + 1, inRight);

		return root;
	}

}
