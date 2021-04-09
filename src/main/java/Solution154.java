/** 搜索旋转排序数组 II */
public class Solution154 {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int pivot = low + (high - low) / 2;
      if (nums[pivot] < nums[high]) {
        high = pivot;
      } else if (nums[pivot] > nums[high]) {
        low = pivot+1;
      } else {
        high -= 1;
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    Solution154 solution75 = new Solution154();
    int[] nums = {2,2,2,2,1};
    System.out.println(solution75.findMin(nums));
  }
}
