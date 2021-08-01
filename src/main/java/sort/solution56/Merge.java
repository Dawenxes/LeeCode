package sort.solution56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; ) {
            int end = intervals[i][1];
            int start = intervals[i][0];
            while (i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            ans.add(new int[]{start, end});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
