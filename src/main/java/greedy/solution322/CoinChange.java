package greedy.solution322;

public class CoinChange {
    int[] mino;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        mino = new int[amount+1];
        return findWay(coins, amount);
    }

    private int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mino[amount] != 0) {
            return mino[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int way = findWay(coins, amount - coins[i]);
            if (way > 0) {
                min = way + 1;
            }
        }
        mino[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return min;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange.coinChange(new int[]{1, 2, 5}, 11);
    }
}
