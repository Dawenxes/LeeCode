package listlink.solution142;

import common.ListNode;

public class DetectCycle_2 {

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast && fast != null) {
        fast = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return fast;
      }
    }
    return null;
  }
}
