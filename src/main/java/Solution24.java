/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution24 {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        Solution24 solution75 = new Solution24();
        ListNode listNode = new ListNode(1);
        ListNode next1 = new ListNode(2);
        listNode.next = next1;
        ListNode next3 = new ListNode(3);
        next1.next = next3;
        ListNode next4 = new ListNode(4);
        next3.next = next4;
        soutListNode(listNode);
        soutListNode(solution75.swapPairs(listNode));
    }

    static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val + "--->");
            node = node.next;
        }
    }
}
