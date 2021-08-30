package listlink.solution26;

public class RemoveDuplicates_4 {
	public static void main(String[] args) {
		RemoveDuplicates_4 removeDuplicates = new RemoveDuplicates_4();
		System.out.println(removeDuplicates.removeDuplicates(new int[]{1, 1, 2}));
	}

	public int removeDuplicates(int[] nums) {
		int left = 0, right = 1;
		while (right < nums.length) {
			if (nums[right - 1] != nums[right]) {
				left++;
				nums[left] = nums[right];
			}
			right++;
		}
		return left + 1;
	}
}
