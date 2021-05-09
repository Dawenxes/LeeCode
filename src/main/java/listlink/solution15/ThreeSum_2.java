package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_2 {
  public List<List<Integer>> threeSum_2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int first = 0; first < nums.length; first++) {
      if (first == 0 || nums[first] != nums[first - 1]) {
        int second = first + 1, third = nums.length - 1;
        while (second < third) {
          if (nums[first] + nums[second] + nums[third] == 0) {
            ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
            while (second < third && nums[second] == nums[second + 1]) {
              second++;
            }
            while (second < third && nums[third] == nums[third - 1]) {
              third--;
            }
            second += 1;
            third -= 1;
          } else if (nums[first] + nums[second] + nums[third] < 0) {
            second++;
          } else {
            third--;
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
    ThreeSum_2 threeSum_1 = new ThreeSum_2();
    List<List<Integer>> lists = threeSum_1.threeSum_2(nums);
    System.out.println(lists.toString());
  }
}
