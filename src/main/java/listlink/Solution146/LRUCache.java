package listlink.Solution146;

import java.util.HashMap;

public class LRUCache {
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

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new LRUNode<Integer>();
    this.tail = new LRUNode<Integer>();
    this.head.next = this.tail;
    this.tail.pre = this.head;

    this.map = new HashMap<Integer, LRUNode<Integer>>();
  }

  public int get(int key) {
    LRUNode<Integer> value = map.get(key);
    if (value != null) {
      // 移到链表前面
      moveNodeToFirst(value);
      return value.getValue();
    }
    return -1;
  }

  public void put(int key, int value) {
    // 如果关键字已经存在，则变更其数据值；
    LRUNode<Integer> tlruNode = map.get(key);
    if (tlruNode != null) {
      tlruNode.setValue(value);
      // 移到链表前面
      moveNodeToFirst(tlruNode);
      return;
    }
    // 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    if (map.size() >= capacity) {
      // 移掉尾节点
      removeTailNode();
    }
    // 如果关键字不存在，则插入该组「关键字-值」。
    LRUNode<Integer> value1 = new LRUNode<Integer>(key,value);
    // 设置到头部
    resetHead(value1);
    map.put(key, value1);
  }

  private void resetHead(LRUNode<Integer> value1) {
    this.head.next.pre = value1;
    value1.next = this.head.next;
    this.head.next = value1;
    value1.pre = this.head;
  }

  private void removeTailNode() {
    map.remove(this.tail.pre.getKey());
    this.tail.pre.pre.next = this.tail;
    this.tail.pre = this.tail.pre.pre;
  }

  private void moveNodeToFirst(LRUNode<Integer> value) {
    value.pre.next = value.next;
    value.next.pre = value.pre;
    resetHead(value);

  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
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
