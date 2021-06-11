package listlink.solution26;

import common.CommonUtil;

public class RemoveDuplicates_3 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left++;
    }

    public static void main(String[] args) {
        RemoveDuplicates_3 removeDuplicates = new RemoveDuplicates_3();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,2}));
    }
}
