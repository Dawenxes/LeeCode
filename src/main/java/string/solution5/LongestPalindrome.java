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
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int j = 0; j < len - L + 1; j++) {
                int end = j + L - 1;

                if (charArray[j] != charArray[end]) {
                    dp[j][end] = false;
                    continue;
                } else {
                    if (L < 3) {
                        dp[j][end] = true;
                    } else {
                        dp[j][end] = dp[j + 1][end - 1];
                    }
                }
                if (dp[j][end]) {
                    begin = j;
                    maxLen = Math.max(maxLen, L);
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
