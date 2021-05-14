package listlink.solution26;

public class RemoveDuplicates_1 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right != 0 && nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates_1 removeDuplicates = new RemoveDuplicates_1();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,2}));
    }
}
