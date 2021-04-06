import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1002 {
    // 计数排序，其实感觉像桶排序
    public List<String> commonChars(String[] A) {
        int[] minFlag = new int[26];
        Arrays.fill(minFlag, Integer.MAX_VALUE);
        for (String s : A) {
            char[] chars = s.toCharArray();
            int[] tmp = new int[26];
            for (char ch : chars) {
                tmp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFlag[i] = Math.min(tmp[i], minFlag[i]);
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFlag[i]; j++) {
                strings.add(String.valueOf((char) (i + 'a')));
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        String[] nums = {"bella","label","roller"};
        Solution1002 solution75 = new Solution1002();
        System.out.println(Arrays.toString(nums));
        List<String> result = solution75.commonChars(nums);
        System.out.println(result.toString());
    }
}
