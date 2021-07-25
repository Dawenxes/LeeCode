package contest.week251.solution5824;

import java.util.Arrays;

/**
 * @Description: 子字符串突变后可能得到的最大整数
 * @ClassName: MaximumNumber
 * @Author: zbn
 * @Date: 2021/7/25 11:11
 */

public class MaximumNumber {
    public String maximumNumber(String num, int[] change) {
        char[] chs = num.toCharArray();
        char[] c = Arrays.copyOf(chs, chs.length);
        int i = 0;
        long ans = Long.parseLong(num);
        while (i < num.length()) {
            int j = i;
            while (j < num.length() && chs[j] - '0' < change[chs[j] - '0']) {
                chs[j] = (char) (change[chs[j] - '0'] + '0');
                j++;
                ans = Math.max(Long.parseLong(new String(chs)), ans);
            }
            chs = c;
            i++;
        }
        String result = String.valueOf(ans);
        while (result.length() < num.length()) {
                result = "0".concat(result);
        }
        return result;
    }


    public static void main(String[] args) {
        MaximumNumber maximumNumber = new MaximumNumber();
        System.out.println(maximumNumber.maximumNumber("334111",
                new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
    }
}
