package everyday.solution517;

import java.util.Arrays;

public class FindMinMoves {
	public int findMinMoves(int[] machines) {
		int sum = Arrays.stream(machines).sum();
		if (sum % machines.length != 0) {
			return -1;
		}
		int dev = sum / machines.length;
		return Arrays.stream(machines).map(i -> {
			if (i < dev) {
				return i - dev;
			} else {
				return 0;
			}
		}).sum();
	}
}
