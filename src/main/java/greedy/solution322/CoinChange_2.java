package greedy.solution322;

public class CoinChange_2 {
    int   ans = Integer.MAX_VALUE;
    int[] vi;

    public static void main(String[] args) {
        CoinChange_2 coinChange = new CoinChange_2();
        System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        vi = new int[amount + 1];
        return findWay(coins, amount);
    }

    private int findWay(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (vi[amount] != 0) {
            return vi[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int way = findWay(coins, amount - coins[i]);
            if (way >= 0 && way + 1 < min) {
                min = way + 1;
            }
        }
        vi[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return vi[amount];
    }

}
