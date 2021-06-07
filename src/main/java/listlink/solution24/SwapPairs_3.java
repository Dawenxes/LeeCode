package listlink.solution24;

import common.ListNode;

public class SwapPairs_3 {
    public ListNode swapPairs(ListNode head) {
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode tmp = tmpHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode first = tmp.next;
            ListNode second = tmp.next.next;
            tmp.next = second;
            first.next = second.next;
            second.next = first;
            tmp = first;
        }
        return tmpHead.next;
    }

}
  