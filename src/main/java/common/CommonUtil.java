package common;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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

    /**
     * 解码base64
     *
     * @param base64String
     */
    public  static String decode64(String base64String) {
        byte[] decode = Base64.getDecoder().decode(base64String);
        return new String(decode);
    }

    /**
     * 译码base64
     *
     * @param src
     */
    public  static String decode64(byte[] src) {
        byte[] encode = Base64.getEncoder().encode(src);
        return new String(encode);
    }

    public static void main(String[] args) {
        String str = "eyJmaWVsZHMiOlt7Il9fY29uZmlnX18iOnsibGFiZWwiOiLlkIzmhI8iLCJ0YWciOiJlbC1zd2l0Y2giLCJ0YWdJY29uIjoic3dpdGNoIiwiZGVmYXVsdFZhbHVlIjpmYWxzZSwiZGVmYXVsdFR5cGUiOiJCb29sZWFuIiwic3BhbiI6MjQsInNob3dMYWJlbCI6dHJ1ZSwibGFiZWxXaWR0aCI6bnVsbCwibGF5b3V0IjoiY29sRm9ybUl0ZW0iLCJyZXF1aXJlZCI6dHJ1ZSwicmVnTGlzdCI6W10sImNoYW5nZVRhZyI6dHJ1ZSwiZG9jdW1lbnQiOiJodHRwczovL2VsZW1lbnQuZWxlbWUuY24vIy96aC1DTi9jb21wb25lbnQvc3dpdGNoIiwiZm9ybUlkIjoxMDEsInJlbmRlcktleSI6IjEwMTE2MjAyOTE5MTc0OTEifSwic3R5bGUiOnt9LCJkaXNhYmxlZCI6ZmFsc2UsImFjdGl2ZS10ZXh0IjoiIiwiaW5hY3RpdmUtdGV4dCI6IiIsImFjdGl2ZS1jb2xvciI6bnVsbCwiaW5hY3RpdmUtY29sb3IiOm51bGwsImFjdGl2ZS12YWx1ZSI6dHJ1ZSwiaW5hY3RpdmUtdmFsdWUiOmZhbHNlLCJfX3ZNb2RlbF9fIjoiZmllbGQxMDEifSx7Il9fY29uZmlnX18iOnsibGFiZWwiOiLlrqHmibnmhI";
        byte[] bytes = DatatypeConverter.parseBase64Binary(str);
        System.out.println(new String(bytes));

    }
}
