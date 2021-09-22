package everyday.solution725;

import common.ListNode;

public class SplitListToParts {
	public ListNode[] splitListToParts(ListNode head, int k) {
		ListNode[] ans = new ListNode[k];
		ListNode tmp = head;
		int length = 0;
		while (tmp != null) {
			tmp = tmp.next;
			length++;
		}
		if (length == 0) {
			return ans;
		}

		int div = length / k;
		int rest = length % k;
		tmp = head;

		ListNode pre = tmp;
		int i = 0;
		for (; i < rest; i++) {
			int j = div;
			ans[i] = pre;
			while (j > 0) {
				pre = pre.next;
				j--;
			}
			if (pre == null) {
				break;
			}
			ListNode last = pre.next;
			pre.next = null;
			pre = last;
		}
		while (i < k && pre != null) {
			int j = div - 1;
			ans[i] = pre;
			while (j > 0) {
				pre = pre.next;
				j--;
			}
			ListNode last = pre.next;
			pre.next = null;
			pre = last;
			i++;
		}
		while (i < k) {
			ans[i] = null;
			i++;
		}
		return ans;
	}
}
