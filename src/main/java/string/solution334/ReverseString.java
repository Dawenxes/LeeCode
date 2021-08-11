package string.solution334;

import java.util.Arrays;

/**
 * @Description: 反转字符串
 * @ClassName: ReverseString
 * @Author: zbn
 * @Date: 2021/8/11 10:47
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] chars = {'a', 'b', 'c', 'd'};
        reverseString.reverseString(chars);
        System.out.println(Arrays.toString(chars));

    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        for (; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
