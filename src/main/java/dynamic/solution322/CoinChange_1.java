package dynamic.solution322;

import java.util.Arrays;

public class CoinChange_1 {
    public int coinChange(int[] coins, int amount) {
        int[] vi = new int[amount + 1];
        Arrays.fill(vi, amount + 1);
        vi[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    vi[i] = Math.min(vi[i], vi[i - coins[j]] + 1);
                }
            }
        }
        return vi[amount] > amount ? -1 : vi[amount];
    }

    public static void main(String[] args) {
        CoinChange_1 coinChange = new CoinChange_1();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
