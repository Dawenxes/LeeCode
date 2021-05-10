package common;

public class CommonUtil {
    /**
     * 给数组转换位置
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 数组转化成链表
     *
     * @param nums
     * @return
     */
    public static ListNode convertToLink(int[] nums) {
        ListNode head = new ListNode();
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = head.next;
            head.next = node;
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param listNode
     */
    public  static void soutListNode(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print("--->");
            } else {
                System.out.println();
            }
        }
    }
}
