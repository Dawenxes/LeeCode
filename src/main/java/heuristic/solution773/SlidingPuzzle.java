package heuristic.solution773;

import java.util.*;

/**
 * @Description: 滑动谜题
 * @ClassName: SlidingPuzzle
 * @Author: zbn
 * @Date: 2021/7/21 10:17
 */
public class SlidingPuzzle {
    static class AStar {
        // 曼哈顿距离
        public static int[][] dist = {
                {0, 1, 2, 1, 2, 3},
                {1, 0, 1, 2, 1, 2},
                {2, 1, 0, 3, 2, 1},
                {1, 2, 3, 0, 1, 2},
                {2, 1, 2, 1, 0, 1},
                {3, 2, 1, 2, 1, 0}
        };

        public String status;
        public int f, g, h;

        public AStar(String status, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status);
            this.f = this.g + this.h;
        }

        // 计算启发函数
        public static int getH(String status) {
            int ret = 0;
            for (int i = 0; i < 6; ++i) {
                if (status.charAt(i) != '0') {
                    ret += dist[i][status.charAt(i) - '1'];
                }
            }
            return ret;
        }
    }

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[] rowBoard = new char[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowBoard[i * n + j] = (char) ('0' + board[i][j]);
            }
        }
        String s = new String(rowBoard);
        String lastStr = "123450";
        if (s.equals(lastStr)) {
            return 0;
        }
        Queue<AStar> priorityQueue = new PriorityQueue<>(new Comparator<AStar>() {
            @Override
            public int compare(AStar o1, AStar o2) {
                return o1.f - o2.f;
            }
        });
        AStar initial = new AStar(s, 0);
        priorityQueue.offer(initial);
        Set<String> seen = new HashSet<String>();
        seen.add(initial.status);
        while (!priorityQueue.isEmpty()) {
            AStar cur = priorityQueue.poll();
            String status = cur.status;
            char[] charArray = status.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (status.charAt(i) == '0') {
                    for (int j = 0; j < neighbors[i].length; j++) {
                        swap(charArray, i, neighbors[i][j]);
                        String nextStr = new String(charArray);
                        if (!seen.contains(nextStr)) {
                            if (lastStr.equals(nextStr)) {
                                return cur.g + 1;
                            }
                            AStar nextStar = new AStar(nextStr, cur.g + 1);
                            priorityQueue.add(nextStar);
                            seen.add(nextStr);
                        }
                        swap(charArray, i, neighbors[i][j]);
                    }
                }
            }
        }
        return -1;
    }

    public void swap(char[] nums, int left, int right) {
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
    }
}