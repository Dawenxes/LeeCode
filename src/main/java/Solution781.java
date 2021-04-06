import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution781 {
  public int numRabbits(int[] answers) {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int answer : answers) {
      map.put(answer, map.getOrDefault(answer, 0) + 1);
    }
    for (Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
      // Math.round(integerIntegerEntry.getValue() / (integerIntegerEntry.getKey() + 1)) 算出有多少种不同的种类
      sum += Math.ceil(integerIntegerEntry.getValue().doubleValue() / (integerIntegerEntry.getKey() + 1))
              * (integerIntegerEntry.getKey() + 1);
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    Solution781 solution75 = new Solution781();
    System.out.println(Arrays.toString(nums));
    int result = solution75.numRabbits(nums);
    System.out.println(result);
  }
}
