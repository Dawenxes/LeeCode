package contest.week251.solution5823;

/**
 * @Description: 字符串转化后的各位数字之和
 * @ClassName: Solution5823
 * @Author: zbn
 * @Date: 2021/7/25 10:44
 */

public class GetLucky {
    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            stringBuilder.append(c - 'a'+1);
        }

        String str = stringBuilder.toString();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ch : str.toCharArray()) {
                int tmp = ch - '0';
                sum = sum + tmp;
            }
            ans = sum;
            str = String.valueOf(ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        GetLucky getLucky = new GetLucky();
        System.out.println(getLucky.getLucky("zbax", 2));
    }

}
