import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    // 计数排序，其实感觉像桶排序
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            /*if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }*/
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        Solution1 solution75 = new Solution1();
        System.out.println(Arrays.toString(nums));
        int[] result = solution75.twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}
