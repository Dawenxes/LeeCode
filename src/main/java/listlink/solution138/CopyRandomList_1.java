package listlink.solution138;

import common.random.Node;

import java.util.HashMap;

public class CopyRandomList_1 {
  HashMap<Node, Node> randomNodeRandomNodeHashMap = new HashMap<>();

  // 递归
  public Node copyRandomList_1(Node head) {
    if (head == null) {
      return null;
    }
    if (randomNodeRandomNodeHashMap.containsKey(head)) {
      return randomNodeRandomNodeHashMap.get(head);
    }
    Node randomNode = new Node(head.val, null, null);
    randomNodeRandomNodeHashMap.put(head, randomNode);
    randomNode.next = this.copyRandomList_1(head.next);
    randomNode.random = this.copyRandomList_1(head.random);
    return randomNode;
  }

  // 迭代
  public Node copyRandomList_2(Node head) {
    if (head == null) {
      return null;
    }
    Node newNode = new Node(head.val);
    Node oldNode = head;
    while (oldNode != null) {
      newNode.next = getCloneNode(newNode.next);
      newNode.random = getCloneNode(newNode.random);
      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return randomNodeRandomNodeHashMap.get(head);
  }

  private Node getCloneNode(Node next) {
    if (next == null) {
      return null;
    }
    if (randomNodeRandomNodeHashMap.containsKey(next)) {
      return randomNodeRandomNodeHashMap.get(next);
    } else {
      Node node = new Node(next.val);
      randomNodeRandomNodeHashMap.put(next, node);
      return node;
    }
  }

  // 迭代
  public Node copyRandomList_3(Node head) {
    if (head == null) {
      return null;
    }
    Node tmp = head;
    // 复制所有节点
    while (tmp != null) {
      Node node = new Node(tmp.val, tmp.next, null);
      tmp.next = node;
      tmp = node.next;
    }
    tmp=head;
    while (tmp != null) {
      Node newNode = tmp.next;
      newNode.random = (tmp.random != null) ? tmp.random.next : null;
      tmp = tmp.next.next;
    }
    tmp=head;
    Node newHead = tmp.next;
    Node tmpNewHead = tmp.next;
    while (tmp != null) {
      tmp.next = newHead.next;
      newHead.next = (newHead.next != null) ? newHead.next.next : null;
      tmp = tmp.next;
      newHead = newHead.next;
    }
    return tmpNewHead;
  }
}
