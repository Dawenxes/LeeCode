package listlink.solution189;

import common.CommonUtil;

import java.util.Arrays;

public class Rotate_2 {
  public void rotate(int[] nums, int k) {


  }

  public int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }

  public void rotate_reversed(int[] nums, int k) {

  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      CommonUtil.swap(nums, start++, end--);
    }
  }

  public static void main(String[] args) {
    Rotate_2 rotate_1 = new Rotate_2();
    int[] ints = {1, 2, 3, 4, 5, 6, 7};
    rotate_1.rotate(ints, 3);
    System.out.println(Arrays.toString(ints));
  }
}
