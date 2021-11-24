package greedy.solution45;

public class Jump_1 {
	public static void main(String[] args) {
		Jump_1 jump = new Jump_1();
		System.out.println(jump.jump1(new int[]{2, 3, 1, 1, 4}));
	}

	public int jump1(int[] nums) {
		int n = nums.length;
		int maxStep = 0;
		int end = 0;
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (maxStep >= i) {
				maxStep = Math.max(nums[i] + i, maxStep);
				if (i == end) {
					end = maxStep;
					result++;
				}
			} else {
				return -1;
			}
		}
		return result;
	}

}

