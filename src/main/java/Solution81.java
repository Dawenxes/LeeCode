/** 搜索旋转排序数组 II */
public class Solution81 {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (nums.length == 1) {
      return nums[0] == target;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        ++left;
        --right;
        continue;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && nums[mid] >= target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && nums[right] >= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution81 solution75 = new Solution81();
    int[] nums = {5,1,3};
    System.out.println(solution75.search(nums, 3));
  }
}
