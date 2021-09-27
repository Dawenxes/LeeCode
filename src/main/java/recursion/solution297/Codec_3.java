package recursion.solution297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class Codec_3 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		treeNode.left = new TreeNode(2);
		Codec_3 codec_1 = new Codec_3();
		String serialize = codec_1.serialize(treeNode);
		System.out.println(serialize);

		TreeNode deserialize = codec_1.deserialize(serialize);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "x,";
		}
		String s = root.val + ",";
		String left = serialize(root.left);
		s = s + left;
		String right = serialize(root.right);
		return s + right;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || "".equals(data)) {
			return null;
		}
		String[] split = data.split(",");
		Queue<String> queue = new LinkedList<>(Arrays.asList(split));
		return _deserialize(queue);
	}

	private TreeNode _deserialize(Queue<String> queue) {
		String remove = queue.remove();
		if ("x".equals(remove)) {
			return null;
		}
		TreeNode treeNode = new TreeNode(Integer.valueOf(remove));
		treeNode.left = _deserialize(queue);
		treeNode.right = _deserialize(queue);
		return treeNode;
	}
}
