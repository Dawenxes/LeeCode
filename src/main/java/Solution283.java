import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,0,3,12 };
        Solution283 solution75 = new Solution283();
        System.out.println(Arrays.toString(nums));
        solution75.moveZeroes(nums);
        System.out.println(nums);
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
