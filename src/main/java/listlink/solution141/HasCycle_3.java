package listlink.solution141;

import common.ListNode;

public class HasCycle_3 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleByHash(ListNode head) {

        return false;
    }
}
