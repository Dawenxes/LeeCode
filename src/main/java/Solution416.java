import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution416 {
        public boolean canPartition(int[] nums) {
            // 求和
            int sum = 0;
            int maxNum = 0;
            int target = 0;// 目标数
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            target = sum >>> 1;
            if (maxNum > target) {
                return false;
            }
            boolean[] tmp = new boolean[target + 1];
            tmp[0] = true;
            tmp[nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = target - nums[i]; j >= 0; j--) {
                    if (tmp[j]) {
                        tmp[j + nums[i]] = true;
                    }
                }
            }
            return tmp[target];
        }



    public static void main(String[] args) {
        int[] s = { 1, 2,3};
        Solution416 solution344 = new Solution416();
        boolean b = solution344.canPartition(s);
        System.out.println(b);
    }
}
