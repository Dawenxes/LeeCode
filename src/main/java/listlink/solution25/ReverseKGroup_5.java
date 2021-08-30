package listlink.solution25;

import common.CommonUtil;
import common.ListNode;

public class ReverseKGroup_5 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		ListNode listNode = CommonUtil.convertToLink(nums);
		CommonUtil.soutListNode(listNode);
		ReverseKGroup_5 reverseList_1 = new ReverseKGroup_5();
		ListNode listNode1 = reverseList_1.reverseKGroup_1(listNode, 2);
		CommonUtil.soutListNode(listNode1);
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

	/**
	 * 反转链表，返回头节点
	 *
	 * @param head 头
	 * @return {@link ListNode}
	 */
	private ListNode reverse(ListNode head) {
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

	//
	public ListNode reverseKGroup_1(ListNode head, int k) {
		int i = 1;
		ListNode tmpHead = head;
		while (tmpHead != null && i++ < k) {
			tmpHead = tmpHead.next;
		}
		if (i <= k && tmpHead == null) {
			return head;
		} else {
			ListNode nextLinkHead = reverseKGroup_1(tmpHead.next, k);
			tmpHead.next = null;
			ListNode reverseHead = reverse(head);
			head.next = nextLinkHead;
			return reverseHead;
		}
	}
}
