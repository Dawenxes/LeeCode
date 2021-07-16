package disjoint_set.solution130;

import java.util.Arrays;

/**
 * @Description: 被围绕的区域
 * @ClassName: Solve
 * @Author: zbn
 * @Date: 2021/7/16 10:49
 */
public class Solve {
    public static void main(String[] args) {
        char[][] chars = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        Solve solve = new Solve();
        solve.solve(chars);
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = board[i][j];
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (cur == 'O') {
                        unionFind.union(m * n, i * n + j);
                    }
                } else {
                    if (board[i][j] == 'O') {
                        if (board[i - 1][j] == 'O') {
                            unionFind.union(i * n + j, (i - 1) * n + j);
                        }
                        if (board[i + 1][j] == 'O') {
                            unionFind.union(i * n + j, (i + 1) * n + j);
                        }
                        if (board[i][j - 1] == 'O') {
                            unionFind.union(i * n + j, i * n + j - 1);
                        }
                        if (board[i][j + 1] == 'O') {
                            unionFind.union(i * n + j, i * n + j + 1);
                        }
                    }
                }

            }

        }
        int tmp = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && unionFind.find(i * n + j) != unionFind.find(m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = 0;
            for (int j = 0; j < n; j++) {
                parent[j] = j;
                count++;
            }
        }

        public int find(int i) {
            int root = i;
            while (parent[root] != root) {
                root = parent[root];
            }
            // 路径压缩
            while (parent[i] != i) {
                int j = parent[i];
                parent[i] = root;
                i = j;
            }
            return root;
        }

        public int union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot != jRoot) {
                parent[jRoot] = iRoot;
                count--;
            }
            return iRoot;
        }
    }
}
