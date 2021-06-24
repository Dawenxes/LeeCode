package listlink.solution146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_2 {
  class LRUNode {
    LRUNode pre;
    LRUNode next;
    int key;
    int value;

    public LRUNode() {
    }

    public LRUNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  int capacity;
  LRUNode head;
  LRUNode tail;
  Map<Integer, LRUNode> map ;


  public LRUCache_2(int capacity) {
    this.capacity = capacity;
    head = new LRUNode();
    tail = new LRUNode();
    head.next = tail;
    tail.pre = head;
    map = new HashMap<>();
  }

  public int get(int key) {
    LRUNode value = map.getOrDefault(key, null);
    if (value != null) {
      moveToHead(value);
      return value.value;
    }
    return -1;
  }

  private void moveToHead(LRUNode value) {
    removeNode(value);
    insertHead(value);
  }

  private void removeNode(LRUNode value) {
    value.pre.next = value.next;
    value.next.pre = value.pre;
  }

  public void put(int key, int value) {
    LRUNode node = map.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
      return;
    }
    LRUNode lruNode = new LRUNode(key, value);
    map.put(key, lruNode);
    if (map.size() > this.capacity) {
      map.remove(tail.pre.key);
      removeNode(tail.pre);
    }
    insertHead(lruNode);
  }

  private void insertHead(LRUNode value) {
    value.next = head.next;
    head.next.pre = value;
    head.next = value;
    value.pre = head;
  }
}
