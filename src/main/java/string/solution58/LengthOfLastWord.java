package string.solution58;

/**
 * @Description: 最后一个单词的长度
 * @ClassName: LengthOfLastWord
 * @Author: zbn
 * @Date: 2021/8/10 11:24
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length();
        while (end > 0 && s.charAt(end - 1) == ' ') {
            end--;
        }
        int ans = 0;
        while (end > 0 && s.charAt(end - 1) != ' ') {
            end--;
            ans++;
        }
        return ans;
    }
}
