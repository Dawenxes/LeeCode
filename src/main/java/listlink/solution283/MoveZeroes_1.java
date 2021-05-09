package listlink.solution283;

import common.CommonUtil;

public class MoveZeroes_1 {
    public void moveZeroes(int[] nums) {
        int nonzero = 0, normal = 0;
        while (normal < nums.length) {
            if (nums[normal] != 0) {
                CommonUtil.swap(nums, nonzero, normal);
                nonzero++;
            }
            normal++;
        }
    }
}
