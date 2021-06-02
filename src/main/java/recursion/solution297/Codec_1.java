package recursion.solution297;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec_1 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return _serialize(root, "");
  }

  private String _serialize(TreeNode root, String str) {
    if (root == null) {
      return str + "*,";
    }
    str += str.valueOf(root.val) + ",";
    str = _serialize(root.left, str);
    str = _serialize(root.right, str);
    return str;
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
    if ("*".equals(queue.peek())) {
      queue.remove();
      return null;
    }
    TreeNode treeNode = new TreeNode(Integer.valueOf(queue.poll()));
    treeNode.left = _deserialize(queue);
    treeNode.right = _deserialize(queue);

    return treeNode;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.left = new TreeNode(3);
    Codec_1 codec_1 = new Codec_1();
    String serialize = codec_1.serialize(treeNode);
    TreeNode deserialize = codec_1.deserialize(serialize);
  }
}
