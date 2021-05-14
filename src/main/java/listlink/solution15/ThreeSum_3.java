package listlink.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_3 {
    public List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        ThreeSum_3 threeSum_1 = new ThreeSum_3();
        List<List<Integer>> lists = threeSum_1.threeSum_2(nums);
        System.out.println(lists.toString());
    }
}
