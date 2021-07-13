package dynamic.solution647;

class CountSubstrings {
    public static void main(String[] args) {
        new CountSubstrings().countSubstrings("fdsklf");
    }

    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ans = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (ci == cj && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}