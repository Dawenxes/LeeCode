import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-colors 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution75 {
    // 计数排序，其实感觉像桶排序
    public void sortColors(int[] nums) {
        // 第一个循环找出最大值
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        // 放入桶中
        int[] bucket = new int[max + 1];
        for (int i : nums) {
            bucket[i]++;
        }
        System.out.println(Arrays.toString(bucket));
        //排序覆盖
        int k = 0;
        int sortedIndex = 0;
        for (int buck : bucket) {
            while (buck > 0) {
                nums[sortedIndex++] = k;
                buck--;
                System.out.println(Arrays.toString(nums));

            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        Solution75 solution75 = new Solution75();
        System.out.println(Arrays.toString(nums));
        solution75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
