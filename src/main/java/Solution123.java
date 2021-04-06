/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * <p>
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution123 {

  public int maxProfit(int[] prices) {
    int buy1 = -prices[0];
    int buy2 = -prices[0];
    int sell1 = buy1 + prices[0];
    int sell2 = buy2 + prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; ++i) {
      buy1 = Math.max(buy1, -prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy2 = Math.max(buy2, sell1 - prices[i]);
      sell2 = Math.max(sell2, buy2 + prices[i]);
    }
    return sell2;
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 2, 0, 1};
    Solution123 solution123 = new Solution123();
    int result = solution123.maxProfit(nums);
    System.out.println(result);
  }
}
