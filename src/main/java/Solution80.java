import java.util.Arrays;

/** 80. 删除有序数组中的重复项 II */
public class Solution80 {
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int slow = 2, fast = 2;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow-2]) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }

  public static void main(String[] args) {
    Solution80 solution75 = new Solution80();
    int[] nums = {1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(nums));
    System.out.println(solution75.removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }
}
