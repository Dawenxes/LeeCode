package common;

public class CommonUtil {
    /**
     * 给数组转换位置
     *
     * @param nums
     * @param left
     * @param right
     */
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
