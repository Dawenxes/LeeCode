package listlink.solution24;

import common.ListNode;

public class SwapPairs_4 {
	public ListNode swapPairs(ListNode head) {
		ListNode tmpHead = new ListNode();
		tmpHead.next = head;
		ListNode tmp = tmpHead;
		while (tmp.next != null && tmp.next.next != null) {
			ListNode first = tmp.next;
			ListNode second = tmp.next.next;
			first.next = second.next;
			second.next = first;
			tmp.next = second;
			tmp = first;
		}
		return tmpHead.next;
	}
}
