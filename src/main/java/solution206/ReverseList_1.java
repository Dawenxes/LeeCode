package solution206;

import common.CommonUtil;
import common.ListNode;

public class ReverseList_1 {
    public ListNode reverseList_1(ListNode head) {
        ListNode pre = head;
        if (head == null||head.next == null) {
            return head;
        }
        ListNode mid = head.next;
        ListNode next = mid.next;
        while (next != null) {
            mid.next = pre;
            pre = mid;
            mid = next;
            next = next.next;
        }
        mid.next = pre;
        head.next = null;
        head = mid;
        return head;
    }
    public ListNode reverseList_2(ListNode head) {
        ListNode pre = null;
        ListNode mid = head;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        return pre;
    }
    public ListNode reverseList_3(ListNode head) {
        ListNode pre = null;
        ListNode mid = head;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = CommonUtil.convertToLink(nums);
        CommonUtil.soutListNode(listNode);
        ReverseList_1 reverseList_1 = new ReverseList_1();
        ListNode listNode1 = reverseList_1.reverseList_1(listNode);
        CommonUtil.soutListNode(listNode1);

    }
}

