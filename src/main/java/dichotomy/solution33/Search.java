package dichotomy.solution33;

public class Search {
    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        new Search().search(ints, 0);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if ((nums[left] > nums[mid] && (target >= nums[left] || target < nums[mid])) || (
                nums[left] < nums[mid] && nums[mid] > target && target >= nums[left])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
