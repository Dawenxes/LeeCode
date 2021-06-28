package greedy.solution322;

import java.util.Arrays;

public class CoinChange_1 {
    int[] mino;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        mino = new int[amount + 1];
        return findWay(coins, amount);
    }

    private int findWay(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (mino[amount] != 0) {
            return mino[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int way = findWay(coins, amount - coins[i]);
            if (way >= 0 && way < min) {
                min = way + 1;
            }
        }
        mino[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return mino[amount];
    }


    int ans = Integer.MAX_VALUE;
    int[] vi;

    public int coinChange_1(int[] coins, int amount) {

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
        if (coins_index < 0) {
            return;
        }
        if (count >= vi[amount]) {
            return;
        }
        for (int k = amount / coins[coins_index]; k >= 0 && count + k < ans; k--) {
            _greedy(coins, amount - k * coins[coins_index], coins_index - 1, count + k);
        }
        vi[amount] = Math.min(vi[amount], count);
    }


    public static void main(String[] args) {
        CoinChange_1 coinChange = new CoinChange_1();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
