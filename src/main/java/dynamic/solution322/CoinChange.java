package dynamic.solution322;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] vi = new int[amount + 1];
        Arrays.fill(vi, amount + 1);
        vi[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length-1; j >=0 ; j--) {
                if (i - coins[j] >= 0 ) {
                    vi[i] = Math.min(vi[i - coins[j]] + 1, vi[i]);
                }
            }
        }
        return vi[amount]>amount?-1:vi[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
