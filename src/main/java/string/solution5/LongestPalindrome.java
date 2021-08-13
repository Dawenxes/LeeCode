package string.solution5;

/**
 * @Description: 最长回文子串
 * @ClassName: LongestPalindrome
 * @Author: zbn
 * @Date: 2021/8/12 10:27
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int i1 = expandAroundCenter(s, i, i);
            int i2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(i2, i1);
            if (max > (end - start + 1)) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }

}
