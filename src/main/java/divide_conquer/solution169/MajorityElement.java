package divide_conquer.solution169;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    return _majorityElement(nums, 0, nums.length - 1);
  }

  private int _majorityElement(int[] nums, int lower, int higher) {
    if (lower == higher) {
      return nums[lower];
    }
    int mid = (higher - lower) / 2 + lower;
    int left = _majorityElement(nums, lower, mid);
    int right = _majorityElement(nums, mid + 1, higher);
    if (left == right) {
      return left;
    }
    int left_ = count(nums, left, lower, higher);
    int right_ = count(nums, right, lower, higher);
    return left_ > right_ ? left : right;
  }

  private int count(int[] nums, int right, int lower, int higher) {
    int count = 0;
    for (int i = lower; i <= higher; i++) {
      if (nums[i] == right) {
        count++;
      }
    }
    return count;
  }
}
