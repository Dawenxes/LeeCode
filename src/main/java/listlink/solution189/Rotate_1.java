package listlink.solution189;

import common.CommonUtil;

import java.util.Arrays;

public class Rotate_1 {
  public void rotate(int[] nums, int k) {
    int tmp = 0;
    int v = gcd(nums.length, k);
    while (tmp < v) {
      int tmpValue;
      int pre = nums[tmp];
      int current = tmp;
      do {
        int x = (current + k) % (nums.length);
        tmpValue = nums[x];
        nums[x] = pre;
        pre = tmpValue;
        current = x;
      } while (tmp != current);
      tmp++;
    }
  }

  public int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }

  public void rotate_reversed(int[] nums, int k) {
    k %= nums.length;
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
    Rotate_1 rotate_1 = new Rotate_1();
    int[] ints = {1, 2, 3, 4, 5, 6, 7};
    rotate_1.rotate(ints, 3);
    System.out.println(Arrays.toString(ints));
  }
}
