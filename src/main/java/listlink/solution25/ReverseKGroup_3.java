package listlink.solution25;

import common.CommonUtil;
import common.ListNode;

public class ReverseKGroup_3 {
    //
    public ListNode reverseKGroup_1(ListNode head, int k) {
        int i = 1;
        ListNode headTmp = head;
        while (i++ < k && headTmp != null) {
            headTmp = headTmp.next;
        }
        if (i < k || headTmp == null) {
            return head;
        } else {
            ListNode subHead = reverseKGroup_1(headTmp.next, k);
            headTmp.next = null;
            ListNode courrentHead = reverse(head);
            head.next = subHead;
            return courrentHead;
        }
    }

    public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode hair = new ListNode();
        ListNode pre = hair;
        hair.next = head;
        ListNode preHeadTmp = head;
        ListNode afterHeadTmp = head;
        while (preHeadTmp != null) {
            int i = 1;
            while (i++ < k && preHeadTmp != null) {
                preHeadTmp = preHeadTmp.next;
            }
            if (i > k && preHeadTmp != null) {
                ListNode tmp = preHeadTmp.next;
                preHeadTmp.next = null;
                ListNode courrentHead = reverse(afterHeadTmp);
                afterHeadTmp.next = tmp;
                hair.next = courrentHead;
                hair = afterHeadTmp;
                preHeadTmp = afterHeadTmp.next;
                afterHeadTmp = preHeadTmp;
            }
        }
        return pre.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = head;
        if (head == null || head.next == null) {
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = CommonUtil.convertToLink(nums);
        CommonUtil.soutListNode(listNode);
        ReverseKGroup_3 reverseList_1 = new ReverseKGroup_3();
        ListNode listNode1 = reverseList_1.reverseKGroup_2(listNode.next, 2);
        CommonUtil.soutListNode(listNode1);
    }
}
