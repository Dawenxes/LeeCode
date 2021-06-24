package listlink.solution189;

import common.CommonUtil;

import java.util.Arrays;

public class Rotate_3 {
    public void rotate(int[] nums, int k) {
        int numRotated = 0;
        int nextRotatedNum = nums[0];
        int cur = 0;
        int length = nums.length;
        int start = 0;
        while (numRotated < length) {
            do {
                int nextCur = ((cur + k) % length);
                int tmp = nums[nextCur];
                nums[nextCur] = nextRotatedNum;
                nextRotatedNum = tmp;
                cur = nextCur;
                numRotated++;
            } while (start != cur);
            if (++start < length) {
                cur = start;
                nextRotatedNum = nums[start];
            }
        }
    }

    public int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }

    public void rotate_reversed(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            CommonUtil.swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        Rotate_3 rotate_1 = new Rotate_3();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate_1.rotate_reversed(ints, 20);
        System.out.println(Arrays.toString(ints));
    }
}
