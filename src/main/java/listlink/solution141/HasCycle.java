package listlink.solution141;

import common.ListNode;

import java.util.HashSet;

public class HasCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head.next, slow = head;
    while (fast != slow) {
      if (fast == null || fast.next == null) {
        return false;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return true;
  }

  public boolean hasCycleByHash(ListNode head) {
    ListNode tmp = head;
    HashSet<ListNode> listNodes = new HashSet<>();
    while (tmp != null) {
      if (!listNodes.add(tmp)) {
        return true;
      }
    }
    return false;
  }
}
