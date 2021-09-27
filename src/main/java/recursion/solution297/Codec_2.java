package recursion.solution297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class Codec_2 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.right = new TreeNode(2);
		treeNode.left = new TreeNode(3);
		Codec_2 codec_1 = new Codec_2();
		String serialize = codec_1.serialize(treeNode);
		TreeNode deserialize = codec_1.deserialize(serialize);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return _serialize(root, "");
	}

	private String _serialize(TreeNode root, String str) {
		if (root == null) {
			return str + "x,";
		}
		String tmp = str + root.val + ",";
		String sLeft = _serialize(root.left, tmp);
		return _serialize(root.right, sLeft);
	}

	private void visit(TreeNode root, String str) {
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] values = data.split(",");
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(values));
		return _deserialize(queue);
	}

	private TreeNode _deserialize(Queue<String> queue) {
		String node = queue.remove();
		if ("x".equals(node)) {
			return null;
		}
		TreeNode treeNode = new TreeNode(Integer.valueOf(node));
		treeNode.left = _deserialize(queue);
		treeNode.right = _deserialize(queue);
		return treeNode;
	}
}
