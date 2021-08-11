package string.solution438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 找到字符串中所有字母异位词
 * @ClassName: FindAnagrams
 * @Author: zbn
 * @Date: 2021/8/11 12:54
 */
public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sn = s.length();
        int pn = p.length();

        List<Integer> res = new ArrayList<>();

        if (sn < pn)
            return res;

        int need_cnt = pn;
        Map<Character, Integer> need_char_cnt = new HashMap<>();
        for (int i = 0; i < pn; i++) {
            char c = p.charAt(i);
            need_char_cnt.put(c, need_char_cnt.getOrDefault(c, 0) + 1);
        }

        // ---- 先统计第一个窗口长度
        for (int i = 0; i < pn; i++) {
            char c = s.charAt(i);
            if (need_char_cnt.containsKey(c)) {
                if (need_char_cnt.get(c) > 0) {
                    need_cnt--;
                }
                need_char_cnt.put(c, need_char_cnt.get(c) - 1);
            }
        }
        if (need_cnt == 0) {
            res.add(0);
        }

        // ---- s中剩下的区间
        for (int r = pn; r < sn; r++) {
            int l = r - pn;
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (need_char_cnt.containsKey(lc)) {
                // <0说明窗口内有多余的lc，所以此时need_cnt不用变
                if (need_char_cnt.get(lc) >= 0) {
                    need_cnt++;
                }
                need_char_cnt.put(lc, need_char_cnt.get(lc) + 1);
            }
            if (need_char_cnt.containsKey(rc)) {
                // >0说明有缺少，才会--
                if (need_char_cnt.get(rc) > 0) {
                    need_cnt--;
                }
                need_char_cnt.put(rc, need_char_cnt.get(rc) - 1);
            }
            if (need_cnt == 0) {
                res.add(l + 1);
            }
        }
        return res;
    }
}
