import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution973 {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int K) {

        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void random_select(int[][] points, int left, int right, int k) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, pivotId, right);
        int j = left;
        for (int i = left; i < right; i++) {
            if ((points[i][0] * points[i][0] + points[i][1] * points[i][1]) <= pivot) {
                swap(points, i, j);
                j++;
            }
        }
        swap(points, j, right);
        if (j - left + 1 < k) {
            random_select(points, j + 1, right, k - j + left - 1);
        } else if (j - left + 1 > k) {
            random_select(points, left, j, k);
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    public static void main(String[] args) {
        int[][] nums = { {3,3}, {5,-1}, {-2,4}};
        Solution973 solution75 = new Solution973();
        int[][] ints = solution75.kClosest(nums, 2);
        for (int[] array : ints) {
            System.out.println(Arrays.toString(array));
        }
    }
}
