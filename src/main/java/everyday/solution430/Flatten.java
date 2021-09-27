package everyday.solution430;

import java.util.Deque;
import java.util.LinkedList;

public class Flatten {

	public Node flatten(Node head) {
		Deque<Node> stack = new LinkedList<>();
		Node head1 = head;
		while (head != null) {
			while (head != null && (head.next != null || head.child != null)) {
				if (head.child != null) {
					if (head.next != null) {
						stack.push(head.next);
					}
					head.next = head.child;
					head.child.prev = head;
					head.child = null;
				}
				head = head.next;
			}
			if (!stack.isEmpty()) {
				Node pop = stack.pop();
				head.next = pop;
				pop.prev = head;
			} else {
				head = head.next;
			}
		}
		return head1;
	};


	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}
}
