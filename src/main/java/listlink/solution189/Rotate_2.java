package listlink.solution189;

import common.CommonUtil;

import java.util.Arrays;

public class Rotate_2 {
  public void rotate(int[] nums, int k) {
    int count = gcd(nums.length, k);
    for (int i = 0; i < count; i++) {
      int tmp = i;
      int next = nums[i];
      do {
        int index = (tmp + k) % nums.length;
        int tmpValue = nums[index];
        nums[index] = next;
        next = tmpValue;
        tmp = index;
      } while (tmp != i);
    }
  }

  public int gcd(int x, int y) {
    return x % y == 0 ? y : gcd(y, x % y);
  }

  public void rotate_reversed(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      CommonUtil.swap(nums, start++, end--);
    }
  }

  public static void main(String[] args) {
    Rotate_2 rotate_1 = new Rotate_2();
    int[] ints = {1, 2, 3, 4, 5, 6, 7};
    rotate_1.rotate_reversed(ints, 20);
    System.out.println(Arrays.toString(ints));
  }
}
