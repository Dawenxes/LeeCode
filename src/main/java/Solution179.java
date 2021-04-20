import java.util.Arrays;

/** 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 */
public class Solution179 {
  public String largestNumber(int[] nums) {
    int n = nums.length;
    // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
    Integer[] numsArr = new Integer[n];
    for (int i = 0; i < n; i++) {
      numsArr[i] = nums[i];
    }

    Arrays.sort(numsArr, (x, y) -> {
      long sx = 10, sy = 10;
      while (sx <= x) {
        sx *= 10;
      }
      while (sy <= y) {
        sy *= 10;
      }
      return (int) (-sy * x - y + sx * y + x);
    });

    if (numsArr[0] == 0) {
      return "0";
    }
    StringBuilder ret = new StringBuilder();
    for (int num : numsArr) {
      ret.append(num);
    }
    return ret.toString();

  }

  public static void main(String[] args) {
    Solution179 solution75 = new Solution179();
    int[] nums = {3, 30, 34, 5, 9};
    System.out.println(solution75.largestNumber(nums));
  }
}
