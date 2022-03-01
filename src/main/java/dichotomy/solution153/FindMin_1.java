package dichotomy.solution153;

public class FindMin_1 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
