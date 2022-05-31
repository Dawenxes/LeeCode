package dynamic.solution91;

public class NumDecodings_2 {
  public static void main(String[] args) {
    NumDecodings_2 solution75 = new NumDecodings_2();
    System.out.println(solution75.numDecodings("10011"));
  }

  public int numDecodings(String s) {
    if (s.charAt(0) == '0') {
      return 0;
    }
    int l = s.length();
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    char[] ch = s.toCharArray();
    for (int i = 2; i < l + 1; i++) {
      if (ch[i - 1] == '0') {
        if (ch[i - 2] <= '2' && ch[i - 2] >= '1') {
          dp[i] = dp[i - 2];
        } else {
          return 0;
        }
      } else {
        if (ch[i - 1] <= '6' && ch[i - 1] >= 1 && ch[i - 2] == '2') {
          dp[i] = dp[i - 1] + dp[i - 2];
        } else if (ch[i - 2] == '1') {
          dp[i] = dp[i - 1] + dp[i - 2];
        } else {
          dp[i] = dp[i - 1];
        }
      }
    }
    return dp[s.length()];
  }
}
