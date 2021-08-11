package contest.week253.solution5839;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinStoneSum {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < piles.length; i++) {
            pr.add(piles[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer maxNums = pr.poll();
            double ceil = Math.ceil((double)maxNums / 2);
            pr.add((int)ceil);
        }
        return pr.stream().reduce((a, b) -> a + b).get();
    }

    public static void main(String[] args) {
        MinStoneSum minStoneSum = new MinStoneSum();
        System.out.println(minStoneSum.minStoneSum(new int[] {4, 3, 6, 7}, 3));
    }
}
