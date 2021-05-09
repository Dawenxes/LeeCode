package listlink.Solution146;

import java.util.HashMap;

public class LRUCache_1 {
  class LRUNode<T> {
    T key;
    T value;

    LRUNode<T> pre;
    LRUNode<T> next;

    public T getKey() {
      return key;
    }

    public void setKey(T key) {
      this.key = key;
    }

    public LRUNode() {}

    public LRUNode(T key,T value) {
      this.key = key;
      this.value = value;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }
  }

  private LRUNode<Integer> head;
  private LRUNode<Integer> tail;
  private HashMap<Integer, LRUNode<Integer>> map;
  private int capacity;

  public LRUCache_1(int capacity) {
    this.capacity = capacity;
    this.head = new LRUNode<Integer>();
    this.tail = new LRUNode<Integer>();
    this.head.next = this.tail;
    this.tail.pre = this.head;

    this.map = new HashMap<Integer, LRUNode<Integer>>();
  }

  public int get(int key) {
    LRUNode<Integer> integerLRUNode = map.get(key);
    if (integerLRUNode != null) {
      moveNodeTofirst(integerLRUNode);
      return integerLRUNode.getValue();
    }
    return -1;
  }

  public void put(int key, int value) {
    LRUNode<Integer> nod = new LRUNode<>(key, value);
    LRUNode<Integer> integerLRUNode = map.get(key);
    if (integerLRUNode == null) {
      map.put(key, nod);
      addNodeToFirst(nod);
      if (map.size() > capacity) {
        removeTailNode();
      }
    } else {
      integerLRUNode.setValue(value);
      moveNodeTofirst(integerLRUNode);
    }
  }

  private void removeTailNode() {
    map.remove(tail.pre.getKey());
    tail.pre.pre.next = tail;
    tail.pre = tail.pre.pre;
  }

  private void addNodeToFirst(LRUNode<Integer> nod) {
    this.head.next.pre = nod;
    nod.next = this.head.next;
    this.head.next = nod;
    nod.pre = this.head;
  }


  private void moveNodeTofirst(LRUNode<Integer> integerLRUNode) {
    integerLRUNode.pre.next = integerLRUNode.next;
    integerLRUNode.next.pre = integerLRUNode.pre;
    integerLRUNode.next = this.head.next;
    this.head.next.pre = integerLRUNode;
    integerLRUNode.pre = this.head;
    this.head.next = integerLRUNode;
  }

  public static void main(String[] args) {
    LRUCache_1 lruCache = new LRUCache_1(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));

  }
}
