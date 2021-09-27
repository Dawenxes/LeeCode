package recursion.solution105;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class BuildTree_3 {
	Map<Integer, Integer> inorderMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, Integer preleft, Integer preright, Integer left,
			Integer right) {
		if (left > right) {
			return null;
		}
		TreeNode treeNode = new TreeNode(preorder[preleft]);
		int rootLocation = inorderMap.get(preorder[preleft]);
		int leftLength = rootLocation - left;

		treeNode.left = buildTree(preorder, inorder, preleft + 1, preleft + leftLength, left, rootLocation - 1);
		treeNode.right = buildTree(preorder, inorder, preleft + leftLength + 1, preright, rootLocation + 1, right);
		return treeNode;
	}

}
