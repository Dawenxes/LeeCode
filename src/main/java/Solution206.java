import common.ListNode;

/**
 * 反转链表
 */
public class Solution206 {


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution206 solution75 = new Solution206();
        ListNode listNode = new ListNode(1);
        ListNode next1 = new ListNode(2);
        listNode.next = next1;
        ListNode next3 = new ListNode(3);
        next1.next = next3;
        ListNode next4 = new ListNode(4);
        next3.next = next4;
        soutListNode(solution75.reverseList(listNode));
    }

    static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val + "--->");
            node = node.next;
        }
    }
}
