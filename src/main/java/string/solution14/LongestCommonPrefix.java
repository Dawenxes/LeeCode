package string.solution14;

/**
 * @Description: 最长公共前缀
 * @ClassName: LongestCommonPrefix
 * @Author: zbn
 * @Date: 2021/8/11 10:20
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean flag = true;
        while (true) {
            if (i >= strs[0].length()) {
                flag = false;
                break;
            }
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    break;
                }
            }
            i++;
        }
        return i == 0 ? "" : strs[0].substring(0, flag ? i - 1 : i);
    }
}
