package dynamic.solution818;

/**
 * @Description: 赛车
 * @ClassName: Racecar
 * @Author: zbn
 * @Date: 2021/8/5 10:57
 */
public class Racecar {

    public static void main(String[] args) {
        Racecar racecar = new Racecar();
        System.out.println(racecar.racecar(4));
    }

    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            // 走到(1 << m)-1需要m个A，此时速度为(1 << (m-1))
            int m = 1, j = 1;
            // 这个循环是从4开始的
            for (; j < i; j = (1 << ++m) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - j + p]);
                }
            }
            dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1) + dp[j - i]);
        }
        return dp[target];
    }
}
