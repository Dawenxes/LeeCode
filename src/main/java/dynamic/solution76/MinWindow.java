package dynamic.solution76;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 最小覆盖子串
 * @ClassName: MinWindow
 * @Author: zbn
 * @Date: 2021/7/13 12:58
 */
public class MinWindow {
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("AA", "AA"));
    }

    public String minWindow(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        for (int i = 0; i < tlen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int ansL = -1, ansR = -1;
        int ansLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < slen) {
            char cr = s.charAt(r);
            if (tMap.containsKey(cr)) {
                cnt.put(cr, cnt.getOrDefault(cr, 0) + 1);
            }
            while (check() && l <= r) {
                char cl = s.charAt(l);
                if (r - l + 1 < ansLen) {
                    ansL = l;
                    ansR = r;
                    ansLen = r - l + 1;
                }
                if (tMap.containsKey(cl)) {
                    cnt.put(cl, cnt.get(cl) - 1);
                }
                l++;
            }
            r++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : tMap.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
