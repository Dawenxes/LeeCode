package dynamic.solution322;

import java.util.Arrays;

public class CoinChange_2 {
    public static void main(String[] args) {
        CoinChange_2 coinChange = new CoinChange_2();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] vi = new int[amount + 1];
        Arrays.fill(vi, amount + 1);
        vi[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    vi[i] = Math.min(vi[i - coins[j]] + 1, vi[i]);
                }
            }
        }
        return vi[amount] > amount ? -1 : vi[amount];
    }
}
