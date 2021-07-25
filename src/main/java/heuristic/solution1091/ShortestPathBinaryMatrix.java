package heuristic.solution1091;

import java.util.*;

/**
 * @Description: 二进制矩阵中的最短路径
 * @ClassName: ShortestPathBinaryMatrix
 * @Author: zbn
 * @Date: 2021/7/21 10:12
 */
public class ShortestPathBinaryMatrix {


    public static void main(String[] args) {
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int[][] grid = {{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}};
        int[][] grid2 = {{0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}};
        int[][] grid3 = {{0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 0}};
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
        int[][] grid6 = {{0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0}};

        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid6));
    }


    private int[] X = {0, 1, 1, 1, 0, -1, -1, -1};// 方向数组
    private int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Pair, Integer> visited = new HashMap<>();
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        Queue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.f - o2.f;
            }
        });

        Pair begin = new Pair(0, 0, getH(0, 0, m - 1, n - 1), 1);
        priorityQueue.add(begin);
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            if (cur.m == m - 1 && cur.n == n - 1) {
                return cur.step;
            }
            for (int i = 0; i < 8; i++) {
                int nextM = cur.m + X[i];
                int nextN = cur.n + Y[i];
                Pair pair = new Pair(nextM, nextN, getH(nextM, nextN, m - 1, n - 1), cur.step + 1);
                if (nextM < grid.length && nextM >= 0 && nextN < grid[0].length && nextN >= 0 && grid[nextM][nextN] == 0
                        && (!visited.containsKey(pair) || visited.get(pair) > pair.step)) {
                    if (pair.m == m - 1 && pair.n == n - 1) {
                        return pair.step;
                    }
                    priorityQueue.add(pair);
                    visited.put(pair, pair.step);
                }
            }
        }
        return -1;
    }

    private int getH(int x, int y, int m, int n) {
        return Math.max(Math.abs(m - x), Math.abs(y - n));
    }

    class Pair {
        int m;
        int n;
        int f;
        int h;
        int step;

        public Pair(int m, int n, int h, int step) {
            this.h = h;
            this.step = step;
            this.m = m;
            this.n = n;
            this.f = step + h;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return m == pair.m && n == pair.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, n);
        }
    }
}
