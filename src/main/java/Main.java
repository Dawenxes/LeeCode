import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        String pattrn = in.nextLine();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (isMatch(s[i], pattrn)) {
                result.add(i);
            }
        }
        System.out.println(result);
    }

    // 动态规划
    private static boolean isMatch(String str, String pattrn) {
        int m = str.length();
        int n = pattrn.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char p = pattrn.charAt(j - 1);
                char s = str.charAt(i - 1);
                if (p != '*') {
                    if (p == '.' || p == s) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = dp[i][j - 2];
                    char pre = pattrn.charAt(j - 2);
                    if (pre == '.' || pre == s) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
