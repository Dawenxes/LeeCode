package string.solution541;

/**
 * @Description: 反转字符串 II
 * @ClassName: ReverseStr
 * @Author: zbn
 * @Date: 2021/8/11 10:57
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0, right = k - 1;
        for (; right < s.length(); left = left + 2 * k, right = right + 2 * k) {
            reverseString(chars, left, right);
        }
        if (left < s.length()) {
            reverseString(chars, left, s.length() - 1);
        }
        return new String(chars);
    }

    public void reverseString(char[] s, int l, int k) {
        int left = l, right = k;
        for (; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
