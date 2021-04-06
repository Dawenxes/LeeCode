/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution19 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                    head = head.next;
                    return head;
            }
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;
    }

    public static void main(String[] args) {
        Solution19 solution75 = new Solution19();
        ListNode listNode1 = new ListNode(1);
        ListNode next2 = new ListNode(2);
        listNode1.next = next2;
        ListNode next3 = new ListNode(3);
        next2.next = next3;
        ListNode next4 = new ListNode(4);
        next3.next = next4;
        soutListNode(listNode1);
        soutListNode(solution75.removeNthFromEnd(listNode1,4));
    }

    static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.println(node.val + "--->");
            node = node.next;
        }
    }
}
