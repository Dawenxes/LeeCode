package tree.solution590;

import common.ntree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Postorder {
  List<Integer> list = new ArrayList<>();

  public List<Integer> postorder(Node root) {
    post(root);
    return list;
  }

  public void post(Node root) {
    if (root == null) {
      return;
    }
    if (root.children != null) {
      for (int i = 0; i < root.children.size(); i++) {
        postorder(root.children.get(i));
      }
    }
    visit(root);
  }

  private void visit(Node root) {
    list.add(root.val);
  }

  LinkedList<Integer> list2 = new LinkedList<>();

  Deque<Node> stack = new LinkedList<>();

  public List<Integer> postorder_1(Node root) {
    if (root == null) {
      return list2;
    }
    stack.push(root);

    while (!stack.isEmpty()) {
      root = stack.pop();
      list2.addFirst(root.val);
      for (int i = 0; i < root.children.size(); i++) {
        stack.push(root.children.get(i));
      }
    }
    return list;
  }
}
