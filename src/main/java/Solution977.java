import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1, m = A.length - 1;
        int[] result = new int[A.length];
        while (i <= j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[m] = A[i] * A[i];
                i++;
            } else {
                result[m] = A[j] * A[j];
                j--;
            }
            m--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        Solution977 solution75 = new Solution977();
        System.out.println(Arrays.toString(nums));
        int[] result = solution75.sortedSquares(nums);
        System.out.println(Arrays.toString(result));

    }
}
