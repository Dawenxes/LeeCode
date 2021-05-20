package listlink.solution141;

import common.ListNode;

import java.util.HashSet;

public class HasCycle_2 {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
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
