package listlink.solution21;

import common.ListNode;

public class MergeTwoLists_1 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode list1 = l1, list2 = l2;
    ListNode tmp = new ListNode(), tmp1 = tmp;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tmp1.next = list1;
        list1 = list1.next;
        tmp1 = tmp1.next;
      } else {
          tmp1.next = list2;
          list2 = list2.next;
          tmp1 = tmp1.next;
      }
    }
    while (list1 != null) {
        tmp1.next = list1;
        list1 = list1.next;
        tmp1 = tmp1.next;
    }
      while (list2 != null) {
          tmp1.next = list2;
          list1 = list2.next;
          tmp1 = tmp1.next;
      }
    return tmp.next;
  }
}

