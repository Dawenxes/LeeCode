package tree.solution429;

import common.ntree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
  List<List<Integer>> result = new ArrayList<>();

  Queue<Node> queue = new LinkedList<>();

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) return result;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        node = queue.poll();
        level.add(node.val);
        queue.addAll(node.children);
      }
      result.add(level);
    }
    return result;
  }
  public List<List<Integer>> levelOrder_1(Node root) {
    if (root == null) return result;
    List<Node> previousLayer = new ArrayList<>();
    List<Node> current = new ArrayList<>();
    current.add(root);
    while (!current.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < current.size(); i++) {
        Node node = current.get(i);
        level.add(node.val);
        previousLayer.addAll(node.children);
      }
      result.add(level);
      current = previousLayer;
    }
    return result;
  }

  public void level(Node root, List<Integer> list) {
    List<Integer> nextList = new ArrayList<>();
    if (root == null) {
      return ;
    }
    if (root.children != null) {
      for (int i = 0; i < root.children.size(); i++) {
        Node node = root.children.get(i);
        list.add(node.val);
        level(node, nextList);
      }
    }
    result.add(list);

  }
}
