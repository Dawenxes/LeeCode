package listlink.solution283;

import common.CommonUtil;

public class MoveZeroes_2 {
  public void moveZeroes(int[] nums) {
    int normal = 0, nonZero = 0;
    while (normal < nums.length) {
      if (nums[normal] != 0) {
        CommonUtil.swap(nums, nonZero, normal);
        nonZero++;
      }
      normal++;
    }
  }
}
