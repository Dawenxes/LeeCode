
/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution143 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode listNode = middleNode(head);
        ListNode right_pre = listNode.next;
        listNode.next = null;
        ListNode right = reverseList(right_pre);
        ListNode left = head;
        ListNode left_tmp ;
        ListNode right_tmp ;
        while (right != null && left != null) {
            left_tmp = left.next;
            right_tmp = right.next;

            left.next = right;
            left = left_tmp;

            right.next = left;
            right = right_tmp;

        }
    }

    // 拿中间点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, sole = head;
        while (fast.next != null && fast.next.next != null) {
            sole = sole.next;
            fast = fast.next.next;
        }
        return sole;
    }

    public ListNode reverseList(ListNode head) {
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
        Solution143 solution75 = new Solution143();
        ListNode listNode = new ListNode(1);
        ListNode next1 = new ListNode(2);
        listNode.next = next1;
        ListNode next3 = new ListNode(3);
        next1.next = next3;
        ListNode next4 = new ListNode(4);
        next3.next = next4;
        solution75.reorderList(listNode);
        soutListNode(listNode);
    }

    static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val + "--->");
            node = node.next;
        }
    }
}
