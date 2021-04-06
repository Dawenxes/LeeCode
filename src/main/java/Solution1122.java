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
public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxOfarr1 = 0;
        for (int x : arr1) {
            maxOfarr1 = Math.max(x, maxOfarr1);
        }
        int[] frequery = new int[maxOfarr1 + 1];
        for (int x : arr1) {
            frequery[x]++;
        }
        int[] ans = new int[arr1.length];
        int j = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequery[x]; i++) {
                ans[j++] = x;
            }
            frequery[x] = 0;
        }
        for (int i = 0; i <= maxOfarr1; i++) {
            for (int x = 0; x < frequery[i]; x++) {
                ans[j++] = i;
            }
            frequery[i] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        Solution1122 solution75 = new Solution1122();
        int[] result = solution75.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
