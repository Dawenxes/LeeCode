package divide_conquer.solution322;

import java.util.Arrays;

public class CoinChange_2 {
	public static void main(String[] args) {
		CoinChange_2 coinChange = new CoinChange_2();
		System.out.println(coinChange.coinChange(new int[]{2, 5, 10, 1}, 27));
	}

	public int coinChange(int[] coins, int amount) {
		int[] ints = new int[amount + 1];
		Arrays.fill(ints, Integer.MAX_VALUE);
		ints[0] = 0;
		return findWay(coins, amount, ints);
	}

	private int findWay(int[] coins, int amount, int[] count) {
		if (amount < 0) {
			return -1;
		}
		if (count[amount] < Integer.MAX_VALUE) {
			return count[amount];
		}
		int last = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int way = findWay(coins, amount - coins[i], count);
			if (way >= 0) {
				last = Math.min(way + 1, last);
			}
		}
		count[amount] = last == Integer.MAX_VALUE ? -1 : last;
		return count[amount];
	}

}
