package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_4 {
	public static void main(String[] args) {
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		ThreeSum_4 threeSum_1 = new ThreeSum_4();
		List<List<Integer>> lists = threeSum_1.threeSum(nums);
		System.out.println(lists.toString());
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[left] + nums[right] + nums[i] < 0) {
						left++;
					} else if (nums[left] + nums[right] + nums[i] > 0) {
						right--;
					} else {
						ans.add(Arrays.asList(left, right, i));
						do {
							left++;

						} while (left < right && nums[left] != nums[left - 1]);
						do {
							right++;

						} while (left < right && nums[right] != nums[right + 1]);
					}
				}
			}
		}
		return ans;
	}
}
