package contest.week250.solution5161;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 可以输入的最大单词数
 * @ClassName: CanBeTypedWords
 * @Author: zbn
 * @Date: 2021/7/18 11:41
 */

public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        int ans = 0;
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }
        for (String s : text.split(" ")) {
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (brokenSet.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans ++;
            }
        }
        return ans;
    }
}
