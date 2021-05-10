package listlink.solution142;

import common.ListNode;

import java.util.List;

public class DetectCycle_1 {

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null) {
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }
      slow = slow.next;
      if (slow == fast) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }
}
