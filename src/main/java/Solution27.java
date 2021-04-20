public class Solution27 {
  public int removeElement(int[] nums, int val) {
    int fast = 0, slow = 0;
    while (fast < nums.length) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }

  public static void main(String[] args) {
    Solution27 solution75 = new Solution27();
    int[] nums = {3, 2, 4};
    System.out.println(solution75.removeElement(nums, 3));
  }
}
