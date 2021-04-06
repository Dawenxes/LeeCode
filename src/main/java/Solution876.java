/**
 * 找到原链表的中点
 */
public class Solution876 {
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

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, sole = head;
        while (fast.next != null && fast.next.next != null) {

            sole = sole.next;
            fast = fast.next.next;
        }
        return sole;
    }

    public static void main(String[] args) {
        Solution876 solution75 = new Solution876();
        ListNode listNode = new ListNode(1);
        ListNode next1 = new ListNode(2);
        listNode.next = next1;
        ListNode next3 = new ListNode(3);
        next1.next = next3;
        ListNode next4 = new ListNode(4);
        next3.next = next4;

        ListNode next5 = new ListNode(4);
        next4.next = next5;
        soutListNode(solution75.middleNode(listNode));
    }

    static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val + "--->");
            node = node.next;
        }
    }
}
