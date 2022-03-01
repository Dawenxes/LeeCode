package dynamic.solution5;

/**
 * @Description: 最长回文子串
 * @ClassName: LongestPalindrome
 * @Author: zbn
 * @Date: 2021/8/12 10:27
 */
public class LongestPalindrome_2 {
    public static void main(String[] args) {
        LongestPalindrome_2 longestPalindrome = new LongestPalindrome_2();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
            return s;
        }
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    dp[j][i] = true;
                } else if (i - j == 1) {
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i] && maxLen < i - j + 1) {
                    maxLen = i - j + 1;
                    begin  = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
