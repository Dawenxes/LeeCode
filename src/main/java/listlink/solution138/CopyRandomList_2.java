package listlink.solution138;

import common.random.Node;

import java.util.HashMap;

public class CopyRandomList_2 {
  HashMap<Node, Node> randomNodeRandomNodeHashMap = new HashMap<>();

  // 递归
  public Node copyRandomList_1(Node head) {
    if (head == null) {
      return null;
    }
    if (randomNodeRandomNodeHashMap.containsKey(head)) {
      return randomNodeRandomNodeHashMap.get(head);
    }
    Node node = new Node(head.val, null, null);
    randomNodeRandomNodeHashMap.put(head, node);
    node.next = copyRandomList_1(head.next);
    node.random = copyRandomList_1(head.random);
    return node;
  }

  // 迭代
  public Node copyRandomList_2(Node head) {
    if (head == null) {
      return null;
    }
    Node newHead = new Node(head.val, null, null);
    randomNodeRandomNodeHashMap.put(head, newHead);
    Node tmpHead = head;
    while (tmpHead != null) {
      Node node = getCloneNode(tmpHead);
      node.random = getCloneNode(tmpHead.random);
      node.next = getCloneNode(tmpHead.next);
      tmpHead = tmpHead.next;
    }
    return newHead;
  }

  private Node getCloneNode(Node next) {
    if (next == null) {
      return null;
    }
    if (randomNodeRandomNodeHashMap.containsKey(next)) {
      return randomNodeRandomNodeHashMap.get(next);
    } else {
      Node node = new Node(next.val, null, null);
      randomNodeRandomNodeHashMap.put(next, node);
      return node;
    }
  }

  // 迭代
  public Node copyRandomList_3(Node head) {
    if (head == null) {
      return null;
    }
    Node tmpHead = head;
    while (tmpHead != null) {
      Node node = new Node(tmpHead.val, tmpHead.next, null);
      tmpHead.next = node;
      tmpHead = node.next;
    }

    tmpHead = head;
    Node tmpNewHead = head.next;
    while (tmpHead != null) {
      tmpNewHead.random = tmpHead.random != null ? tmpHead.random.next : null;
      tmpHead = tmpNewHead.next;
      tmpNewHead = tmpHead != null ? tmpHead.next : null;
    }

    tmpHead = head;
    tmpNewHead = head.next;
    Node returnNewHead = head.next;
    while (tmpHead != null) {
      tmpHead.next = tmpNewHead.next;
      tmpNewHead.next = tmpHead.next != null ? tmpHead.next.next : null;
      tmpHead = tmpHead.next;
      tmpNewHead = tmpNewHead.next;
    }
    return returnNewHead;
    }

}
