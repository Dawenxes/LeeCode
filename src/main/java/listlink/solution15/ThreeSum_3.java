package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_3 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        // 跳过重复元素
        int left = i+1, right = nums.length - 1;
        while (left < right) {
          if (nums[left] + nums[right] == -nums[i]) {
            ans.add(Arrays.asList(nums[left], nums[right], nums[i]));
            do {
              left++;
            } while (nums[left] == nums[left - 1] && left < right);
            do {
              right--;
            } while (nums[right] == nums[right + 1]&& left < right);
          } else if (nums[left] + nums[right] < -nums[i]) {
            left++;
          } else if (nums[left] + nums[right] > -nums[i]) {
            right--;
          }
        }
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    ThreeSum_3 threeSum_1 = new ThreeSum_3();
    List<List<Integer>> lists = threeSum_1.threeSum(nums);
    System.out.println(lists.toString());
  }
}
