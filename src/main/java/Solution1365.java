import java.util.Arrays;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        Arrays.fill(counts, 0);
        for (int i : nums) {
            counts[i]++;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                result[i] += counts[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 1, 2, 2, 3 };
        Solution1365 solution75 = new Solution1365();
        System.out.println(Arrays.toString(nums));
        int[] result = solution75.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));

    }
}
