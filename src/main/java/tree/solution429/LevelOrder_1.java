package tree.solution429;

import common.ntree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_1 {
  List<List<Integer>> result = new ArrayList<>();

  Queue<Node> queue = new LinkedList<>();

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return result;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      ArrayList<Integer> every = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        root = queue.poll();
        every.add(root.val);
        if (root.children != null) {
          queue.addAll(root.children);
        }
      }
      result.add(every);
    }
    return result;
  }

  public List<List<Integer>> levelOrder_1(Node root) {
    if (root != null) {
      level(root, 0);
    }
    return result;
  }

  public void level(Node root, int levels) {
    if (result.size() <= levels) {
      result.add(new ArrayList<>());
    }
    result.get(levels).add(root.val);
    if (root.children != null) {
      for (Node child : root.children) {
        level(child, levels + 1);
      }
    }

  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.children = new ArrayList<>();
    node.children.add(new Node(2));
    node.children.add(new Node(3));
    node.children.add(new Node(4));
    LevelOrder_1 levelOrder_1 = new LevelOrder_1();
    levelOrder_1.levelOrder_1(node);
  }
}
