package dichotomy.solution153;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if ((nums[right] > nums[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
