package string.solution680;

/**
 * @Description: 验证回文字符串 Ⅱ
 * @ClassName: ValidPalindrome
 * @Author: zbn
 * @Date: 2021/8/12 9:54
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if (rc == lc) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

}
