package listlink.solution1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_3 {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{};
  }

  public int[] twoSum_1(int[] nums, int target) {
    HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (integerIntegerHashMap.get(target - nums[i]) != null) {
        return new int[]{i, integerIntegerHashMap.get(target - nums[i])};
      }
      integerIntegerHashMap.put(nums[i], i);
    }
    return new int[]{};
  }
}
