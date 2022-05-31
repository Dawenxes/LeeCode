package dynamic.solution152;

public class MaxProduct2 {
  public int maxProduct(int[] nums) {
    int imin = nums[0];
    int imax = nums[0];
    int ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int ia = imax, ii = imin;
      imax = Math.max(Math.max(ia * nums[i], ii*nums[i]), nums[i]);
      imin = Math.min(Math.min(ia * nums[i], ii * nums[i]), nums[i]);
      ans = Math.max(Math.max(imax, imin), ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    MaxProduct2 maxProduct2 = new MaxProduct2();
    System.out.println(maxProduct2.maxProduct(new int[]{5,-2,3,-4,5}));
  }
}
