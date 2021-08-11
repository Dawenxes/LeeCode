package string.solution557;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 反转字符串中的单词 III
 * @ClassName: ReverseWords
 * @Author: zbn
 * @Date: 2021/8/11 11:47
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");

        List<String> stringList = new ArrayList<>();
        for (String s1 : split) {
            stringList.add(reverseString(s1));
        }
        return String.join(" ", stringList);
    }

    public String reverseString(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        for (; left < right; left++, right--) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
        return new String(chars);
    }
}
