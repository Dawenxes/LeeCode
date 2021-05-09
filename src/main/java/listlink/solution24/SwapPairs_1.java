package listlink.solution24;

import common.ListNode;

public class SwapPairs_1 {
  public ListNode swapPairs(ListNode head) {
    ListNode listNode = new ListNode();
    listNode.next = head;
    ListNode temp = listNode;
    while (temp.next != null && temp.next.next != null) {
      ListNode first = temp.next;
      ListNode second = temp.next.next;
      first.next = second.next;
      second.next = first;
      temp.next = second;
      temp = first;
    }
    return listNode.next;
  }
}
