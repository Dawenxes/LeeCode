package listlink.solution138;

import java.util.HashMap;

import common.random.Node;

public class CopyRandomList_4 {
	HashMap<Node, Node> randomNodeRandomNodeHashMap = new HashMap<>();

	// 递归
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node copyHead = randomNodeRandomNodeHashMap.get(head);
		if (copyHead != null) {
			return copyHead;
		}
		Node node = new Node(head.val);
		randomNodeRandomNodeHashMap.put(head, node);
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);
		return node;
	}

	// 迭代
	public Node copyRandomList_1(Node head) {
		Node tmp = head;
		while (head != null) {
			Node node = getCloneNode(head);
			node.next = getCloneNode(head.next);
			node.random = getCloneNode(head.random);
			head = head.next;
		}
		return getCloneNode(tmp);
	}

	private Node getCloneNode(Node head) {
		if (head == null) {
			return null;
		}
		Node node = randomNodeRandomNodeHashMap.get(head);
		if (node != null) {
			return node;
		}
		Node node1 = new Node(head.val);
		randomNodeRandomNodeHashMap.put(head, node1);
		return node1;
	}

	// 迭代
	public Node copyRandomList_2(Node head) {
		if (head == null) {
			return null;
		}
		Node tmp = head;
		// 1
		while (head != null) {
			Node node = new Node(head.val);
			node.next = head.next;
			head.next = node;
			head = head.next;
		}
		// 2 连接random
		head = tmp;
		while (head != null) {
			if (head.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
		// 3 释放
		head = tmp;
		Node newHead = head.next;
		Node tmpHead = head.next;
		while (head != null && head.next.next != null) {
			newHead.next = head.next;
			newHead.next = newHead.next.next;
			head.next = newHead.next;
			head = head.next;
		}
		return tmpHead;
	}
}
