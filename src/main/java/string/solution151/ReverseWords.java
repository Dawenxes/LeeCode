package string.solution151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 翻转字符串里的单词
 * @ClassName: ReverseWords
 * @Author: zbn
 * @Date: 2021/8/11 11:36
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] split = trim.split("\\s+");
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
