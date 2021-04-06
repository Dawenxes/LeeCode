/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/backspace-string-compare 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int a = s.length() - 1, b = t.length() - 1;
        int skips = 0, skipt = 0;

        while (a >= 0 || b >= 0) {
            while (a >= 0) {
                if (s.charAt(a) == '#') {
                    skips++;
                    a--;
                } else if (skips > 0) {
                    skips--;
                    a--;
                } else {
                    break;
                }
            }
            while (b >= 0) {
                if (t.charAt(b) == '#') {
                    skipt++;
                    b--;
                } else if (skipt > 0) {
                    skipt--;
                    b--;
                } else {
                    break;
                }
            }
            if (a >= 0 && b >= 0) {
                if (s.charAt(a) != t.charAt(b)) {
                    return false;
                }
            } else {
                if (a >= 0 || b >= 0) {
                    return false;
                }
            }
            a--;
            b--;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ab#c";
        Solution844 solution75 = new Solution844();
        boolean result = solution75.backspaceCompare(S, T);
        System.out.println(result);
    }
}
