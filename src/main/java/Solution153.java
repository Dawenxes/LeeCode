/** 搜索旋转排序数组 II */
public class Solution153 {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int pivot = low + (high - low) / 2;
      if (nums[pivot] < nums[high]) {
        high = pivot;
      } else {
        low = pivot + 1;
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    Solution153 solution75 = new Solution153();
    int[] nums = {5, 1, 3};
    System.out.println(solution75.findMin(nums));
  }
}
