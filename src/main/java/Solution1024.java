import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        int[] dex = new int[T + 1];
        Arrays.fill(dex, Integer.MAX_VALUE);
        dex[0] = 0;
        for (int i = 0; i <= T; i++) {
            for (int[] clip : clips) {
                if (i > clip[0] && i <= clip[1]) {
                    dex[i] = Math.min(dex[i], dex[clip[0]]+1);
                }
            }
        }
      return dex[T] == Integer.MAX_VALUE  ? -1 : dex[T];
    }

    public static void main(String[] args) {
        int[][] nums = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        Solution1024 solution75 = new Solution1024();
        System.out.println(solution75.videoStitching(nums, 12));
    }
}
