/** 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 */
public class Solution263 {
  public boolean isUgly(int n) {
    if (n <= 0) {
      return false;
    }
    int[] uglyNumbers = {2, 3, 5};
    for (int uglyNumber : uglyNumbers) {
      while (n % uglyNumber == 0) {
        n = n / uglyNumber;
      }
    }
    return n == 1;
  }

  public static void main(String[] args) {
    Solution263 solution75 = new Solution263();
    System.out.println(solution75.isUgly(12));
  }
}
