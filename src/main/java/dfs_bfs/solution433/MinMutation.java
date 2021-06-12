package dfs_bfs.solution433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinMutation {
    char[] mode = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> st = new HashSet<String>();
        Set<String> en= new HashSet<String>();
        Set<String> basic = new HashSet<String>(Arrays.asList(bank));
        if (!basic.contains(end)) {
            return -1;
        }
        st.add(start);
        en.add(end);
        return _bfs(st, en, basic, 0);
    }

    private int _bfs(Set<String> st, Set<String> en, Set<String> basic, int len) {
        if (st.size() == 0) {
            return -1;
        }
        if (st.size() < en.size()) {
            _bfs(en, st, basic, len);
        }
        Set<String> next = new HashSet<String>();
        for (String s : st) {
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < mode.length; j++) {
                    char tmp = stringBuilder.charAt(i);
                    stringBuilder.setCharAt(i, mode[j]);
                    String cur = stringBuilder.toString();
                    if (!basic.contains(cur)) {
                        continue;
                    }
                    if (en.contains(cur)) {
                        return len + 1;
                    }
                    next.add(cur);
                    stringBuilder.setCharAt(i, tmp);
                }
            }
        }

        return _bfs(next, en, basic, len + 1);
    }
}
