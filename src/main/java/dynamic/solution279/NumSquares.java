package dynamic.solution279;

public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minm = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minm = Math.min(minm, dp[i - j * j]);
            }
            dp[i] = minm+1;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(8));
    }
}
