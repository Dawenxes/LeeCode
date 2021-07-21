package heuristic.solution1091;

import java.util.*;

/**
 * @Description: 二进制矩阵中的最短路径
 * @ClassName: ShortestPathBinaryMatrix
 * @Author: zbn
 * @Date: 2021/7/21 10:12
 */
public class ShortestPathBinaryMatrix {
    private int[] X = {0, 1, 1, 1, 0, -1, -1, -1};//方向数组
    private int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) {
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int[][] grid =
                {{0, 1, 1, 0, 0, 0},
                        {0, 1, 0, 1, 1, 0},
                        {0, 1, 1, 0, 1, 0},
                        {0, 0, 0, 1, 1, 0},
                        {1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 0}};
        int[][] grid2 =
                {{0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 0}};
        int[][] grid3 =
                {{0, 1, 0, 1, 0},
                        {1, 0, 0, 0, 1},
                        {0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0}};
        int[][] grid4 = {{0, 1}, {1, 0}};
        int[][] grid5 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0}};


        System.out.println(
                shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid5));

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        HashSet<Pair> visited = new HashSet<>();
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        Map<Pair, Pair> cameForm = new HashMap<>();
        Map<Pair, Pair> pathway = new HashMap<>();
        Queue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int s1 = (o1.m - m) * (o1.m - m) + (o1.n - n) * (o1.n - n);
                int s2 = (o2.m - m) * (o2.m - m) + (o2.n - n) * (o2.n - n);
                return s1 - s2;
            }
        });
        Pair begin = new Pair(0, 0);
        priorityQueue.add(begin);
        Pair pre = null;
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            if (visited.contains(cur)) {
                continue;
            }
            if (process(cur, m - 1, n - 1, pathway, cameForm, pre, visited)) {
                ans = Math.min(pathway.size(), ans);
            }
            generate_relate_nodes(cur, priorityQueue, grid, cameForm, visited);
            pre = cur;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void generate_relate_nodes(Pair cur, Queue<Pair> priorityQueue,
                                       int[][] grid, Map<Pair, Pair> cameForm, HashSet<Pair> visited) {
        for (int i = 0; i < 8; i++) {
            int nextM = cur.m + X[i];
            int nextN = cur.n + Y[i];
            Pair pair = new Pair(nextM, nextN);
            if (nextM < grid.length && nextM >= 0 && nextN < grid[0].length &&
                    nextN >= 0 && grid[nextM][nextN] == 0 && !visited.contains(pair)) {
                priorityQueue.add(pair);
                cameForm.putIfAbsent(pair, cur);
            }
        }
    }

    private boolean process(Pair cur, int m, int n, Map<Pair, Pair> pathway, Map<Pair, Pair> cameForm, Pair pre, HashSet<Pair> visited) {
        Pair curParent = cameForm.get(cur);
        if (pathway.containsKey(curParent)) {
            pathway.clear();

        }
        Pair curTmp = cur;
        while (curParent != null) {
            pathway.put(curParent, curTmp);
            curTmp = curParent;
            curParent = cameForm.get(curTmp);
        }
        if (cur.m == m && cur.n == n) {
            pathway.put(cur, null);
            return true;
        } else {
            visited.add(cur);
            return false;
        }
    }

    class Pair {
        int m;
        int n;

        public Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (m != pair.m) {
                return false;
            }
            return n == pair.n;
        }

        @Override
        public int hashCode() {
            int result = m;
            result = 31 * result + n;
            return result;
        }
    }
}
