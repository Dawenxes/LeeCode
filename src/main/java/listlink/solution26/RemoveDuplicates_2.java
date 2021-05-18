package listlink.solution26;

public class RemoveDuplicates_2 {
    public int removeDuplicates(int[] nums) {
    int left = 0, right = 1;
    while (right<nums.length){
        if (nums[right] != nums[right - 1]) {
            left++;
            nums[left]=nums[right];
        }
        right++;
    }
    return left + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates_2 removeDuplicates = new RemoveDuplicates_2();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,2}));
    }
}
