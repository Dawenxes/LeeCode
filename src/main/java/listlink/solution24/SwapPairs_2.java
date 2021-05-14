package listlink.solution24;

import common.ListNode;

public class SwapPairs_2 {
  public ListNode swapPairs(ListNode head) {
    ListNode listNode = new ListNode();
    listNode.next = head;
    ListNode tmp = listNode;
    while (tmp.next != null && tmp.next.next != null) {
      ListNode first = tmp.next;
      ListNode second = tmp.next.next;
      ListNode next = second.next;
      second.next = first;
      first.next = next;
      tmp.next = second;
      tmp = first;
    }
    return listNode.next;
  }
}
  