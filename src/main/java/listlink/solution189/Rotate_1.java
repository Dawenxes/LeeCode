package listlink.solution189;

import java.util.Arrays;

public class Rotate_1 {
    public void rotate(int[] nums, int k) {
        int i = 0;
        int tmpValue;
        int nextValue = nums[i];
        int tmp = 0;
        int flag =0;
        while (tmp++ < nums.length - 1) {
            if (flag++ == nums.length / k) {
                i = i + 1;
                nextValue = nums[i];
                flag = 0;
            }
            tmpValue = nums[(i + k) % (nums.length - 1)];
            nums[(i + k) % (nums.length - 1)] = nextValue;
            nextValue = tmpValue;
            i = (i + k) % (nums.length - 1);
        }
    }

    public static void main(String[] args) {
        Rotate_1 rotate_1 = new Rotate_1();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate_1.rotate(ints, 3);
        System.out.println(Arrays.toString(ints));

    }
}
