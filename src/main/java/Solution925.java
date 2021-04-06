/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/long-pressed-name 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int a = 0, b = 0;
        while (b < typed.length()) {
            if (a < name.length() && name.charAt(a) == typed.charAt(b)) {
                a++;
                b++;
            } else if (b > 0 && typed.charAt(b - 1) == typed.charAt(b)) {
                b++;
            } else {
                return false;
            }
        }
        return a == name.length();
    }

    public static void main(String[] args) {
        Solution925 solution75 = new Solution925();
        System.out.println(solution75.isLongPressedName("alex", "aaleex"));
    }
}
