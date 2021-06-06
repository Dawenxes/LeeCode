package tree.solution589;

import common.ntree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder_1 {

  List<Integer> list = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    pre(root);
    return list;
  }

  public void pre(Node root) {
    if (root == null) {
      return;
    }
    visit(root);
    for (Node child : root.children) {
      pre(child);
    }
  }

  private void visit(Node root) {
    list.add(root.val);
  }

  Deque<Node> stack = new LinkedList<>();

  public List<Integer> preorder_1(Node root) {
    if (root == null) {
      return list;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.poll();
      visit(root);
      for (int i = root.children.size() - 1; i >= 0; i--) {
        stack.add(root.children.get(i));
      }
    }
    return list;
  }
}
