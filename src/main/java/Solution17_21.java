import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * <p>
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17_21 {
  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int sum = Arrays.stream(height).sum();
    int high = 1;
    int sumV = 0;
    while (left <= right) {
      while (left <= right && height[left] < high) {
        left++;
      }
      while (left <= right && height[right] < high) {
        right--;
      }
      high++;
      sumV += right - left + 1;
    }
    return sumV - sum;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
    Solution17_21 solution75 = new Solution17_21();
    System.out.println(solution75.trap(nums));
  }
}
