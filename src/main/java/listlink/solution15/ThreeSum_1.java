package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_1 {
  // 三重循环
  public List<List<Integer>> threeSum_1(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        for (int i1 = i + 1; i1 < nums.length; i1++) {
          if (i1 == i + 1 || nums[i1] != nums[i1 - 1]) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
              if (i2 == i1 + 1 || nums[i2] != nums[i2 - 1]) {
                check(ans, nums, i, i1, i2);
              }
            }
          }
        }
      }
    }
    return ans;
  }

  public List<List<Integer>> threeSum_2(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> ans = new ArrayList<>();
    for (int first = 0; first < nums.length; first++) {
      if (first == 0 || nums[first] != nums[first - 1]) {
        int second = first + 1, third = nums.length - 1;
        while (second < third) {
          if (nums[first] + nums[second] + nums[third] == 0) {
            ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
            second += 1;
            third -= 1;
            while (second < third && nums[second] == nums[second - 1]) {
              second += 1;
            }
            while (second < third && nums[third] == nums[third + 1]) {
              third -= 1;
            }
          } else if (nums[first] + nums[second] + nums[third] > 0) {
            third -= 1;
          } else {
            second += 1;
          }
        }
      }
    }
    return ans;
  }

  private void check(ArrayList<List<Integer>> ans, int[] nums, int i, int i1, int i2) {
    if (nums[i] + nums[i1] + nums[i2] == 0) {
      ArrayList<Integer> integers = new ArrayList<>();
      integers.add(nums[i]);
      integers.add(nums[i1]);
      integers.add(nums[i2]);
      ans.add(integers);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    ThreeSum_1 threeSum_1 = new ThreeSum_1();
    List<List<Integer>> lists = threeSum_1.threeSum_2(nums);
    System.out.println(lists.toString());
  }
}
