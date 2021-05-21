package listlink.solution206;

import common.CommonUtil;
import common.ListNode;

public class ReverseList_2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next;
        left.next = null;
        while (right != null) {
            ListNode tmp = right.next;
            right.next = left;
            left = right;
            right = tmp;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = CommonUtil.convertToLink(nums);
        CommonUtil.soutListNode(listNode);
        ReverseList_2 reverseList_1 = new ReverseList_2();
        ListNode listNode1 = reverseList_1.reverseList(listNode);
        CommonUtil.soutListNode(listNode1);
    }
}

