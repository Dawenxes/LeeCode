package listlink.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangBoneng
 */
public class LRUCache_3 {
	private Map<Integer, LRUNode> map;
	private LRUNode head;
	private LRUNode tail;
	private int capitable;

	public LRUCache_3(int capitable) {

		map = new HashMap<>();
		head = new LRUNode<>();
		tail = new LRUNode<>();
		head.next = tail;
		tail.pre = head;
		this.capitable = capitable;

	}

	public static void main(String[] args) {
		LRUCache_3 lruCache = new LRUCache_3(2);
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

	private void put(int key, int value) {
		LRUNode lruNode = map.get(key);
		if (lruNode == null) {
			lruNode = new LRUNode<>(key, value);
			map.put(key, lruNode);
			insertToHead(lruNode);
			if (capitable < map.size()) {
				LRUNode removeNode = removeTail();
				map.remove(removeNode.key);
			}
			return;
		}
		lruNode.value = value;
		moveToHead(lruNode);
	}

	private LRUNode removeTail() {
		LRUNode removeNode = tail.pre;
		removeNode.pre.next = tail;
		tail.pre = removeNode.pre;
		return removeNode;
	}

	private int get(int key) {
		LRUNode lruNode = map.get(key);
		if (lruNode == null) {
			return -1;
		}
		moveToHead(lruNode);
		return (int) lruNode.value;
	}

	private void insertToHead(LRUNode lruNode) {
		lruNode.next = head.next;
		head.next.pre = lruNode;
		lruNode.pre = head;
		head.next = lruNode;
	}

	private void moveToHead(LRUNode lruNode) {
		lruNode.pre.next = lruNode.next;
		lruNode.next.pre = lruNode.pre;
		insertToHead(lruNode);
	}

	class LRUNode<T> {
		T key;
		T value;

		LRUNode<T> pre;
		LRUNode<T> next;

		public LRUNode() {
		}

		public LRUNode(T key, T value) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}
	}
}
