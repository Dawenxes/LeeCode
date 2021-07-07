package greedy.solution322;

import java.util.Arrays;

public class CoinChange_2 {
    int ans = Integer.MAX_VALUE;
    int[] vi;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        vi = new int[amount + 1];
        Arrays.fill(vi, Integer.MAX_VALUE);
        _greedy(coins, amount, coins.length - 1, 0);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private void _greedy(int[] coins, int amount, int coins_index, int count) {
        if (amount == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (count >= vi[amount]) {
            return;
        }
        if (count >= ans) {
            return;
        }

        if (coins_index < 0) {
            return;
        }
        for (int k = amount / coins[coins_index]; k >= 0 && k + count < ans; k--) {
            _greedy(coins, amount - k * coins[coins_index], coins_index - 1, count + k);
        }
        vi[amount] = Math.min(count, vi[amount]);
    }


    public static void main(String[] args) {
        CoinChange_2 coinChange = new CoinChange_2();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
