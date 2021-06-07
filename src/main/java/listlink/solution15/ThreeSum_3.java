package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_3 {
  public List<List<Integer>> threeSum_2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);

    return ans;
  }


  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    ThreeSum_3 threeSum_1 = new ThreeSum_3();
    List<List<Integer>> lists = threeSum_1.threeSum_2(nums);
    System.out.println(lists.toString());
  }
}
