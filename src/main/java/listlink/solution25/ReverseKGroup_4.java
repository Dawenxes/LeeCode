package listlink.solution25;

import common.CommonUtil;
import common.ListNode;

public class ReverseKGroup_4 {
    //
    public ListNode reverseKGroup_1(ListNode head, int k) {
        int i = 1;
        ListNode tmpHead = head;
        while (i++ < k && head != null) {
            head = head.next;
        }
        if (i > k && head != null) {
            ListNode subHead = reverseKGroup_1(head.next, k);
            head.next = null;
            ListNode reverse = reverse(tmpHead);
            tmpHead.next = subHead;
            return reverse;
        } else {
            return tmpHead;
        }
    }

    public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode hair = new ListNode();
        ListNode hairTmp = hair;
        hair.next = head;
        ListNode headTmp = head;
        while (headTmp != null) {
            int i = 1;
            while (i++ < k && headTmp != null) {
                headTmp = headTmp.next;
            }
            if (i > k && headTmp != null) {
                ListNode nextHead = headTmp.next;
                headTmp.next = null;
                ListNode reverse = reverse(hairTmp.next);
                ListNode nextHair = hairTmp.next;
                hairTmp.next = reverse;
                hairTmp = nextHair;
                hairTmp.next = nextHead;
                headTmp = nextHead;

            }
        }
        return hair.next;
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
        ReverseKGroup_4 reverseList_1 = new ReverseKGroup_4();
        ListNode listNode1 = reverseList_1.reverseKGroup_2(listNode, 2);
        CommonUtil.soutListNode(listNode1);
    }
}
