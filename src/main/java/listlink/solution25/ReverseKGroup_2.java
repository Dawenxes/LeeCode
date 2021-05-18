package listlink.solution25;

import common.CommonUtil;
import common.ListNode;

public class ReverseKGroup_2 {
  public ListNode reverseKGroup(ListNode head, int k) {
    int i = 1;
    ListNode tmp = head;
    // 每k个元素执行一次递归
    while (i < k && tmp != null) {
      i++;
      tmp = tmp.next;
    }
    if (i < k || tmp == null) {
      // 说明到了链表最末尾的k个元素，直接返回
      return head;
    } else {
      // while循环后，tmp刚好在第k个元素，取第k+1个元素开始下一轮递归
      ListNode next = tmp.next;
      // 后一段和当前段的链表断开，防止后面reverse把后面的链表一起反转了
      tmp.next = null;
      // 递归，每次递归返回的都是链表头部
      ListNode listNode = reverseKGroup(next, k);
      // 因为前面已经将后一段和当前段的链表断开，
      // 这里直接反转k个元素，返回反转后的头部
      ListNode subHead = reverse(head);
      // 此时由于head经过反转，被移到链表尾端，将当前段与后一段相连
      head.next = listNode;
      // 返回连接后的头部
      return subHead;
    }
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
    ReverseKGroup_2 reverseList_1 = new ReverseKGroup_2();
    ListNode listNode1 = reverseList_1.reverseKGroup(listNode.next, 2);
    CommonUtil.soutListNode(listNode1);
  }
}
