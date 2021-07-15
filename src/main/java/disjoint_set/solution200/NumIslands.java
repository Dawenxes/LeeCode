package disjoint_set.solution200;

/**
 * @Description: 岛屿数量
 * @ClassName: NumIslands
 * @Author: zbn
 * @Date: 2021/7/15 17:24
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * nc + j, (i - 1) * nc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {

                        uf.union(i * nc + j, i * nc + j - 1);
                    }
                    if (i + 1 < nr && grid[i + 1][j] == '1') {

                        uf.union(i * nc + j, (i + 1) * nc + j);
                    }
                    if (j + 1 < nc && grid[i][j + 1] == '1') {
                        uf.union(i * nc + j, i * nc + j + 1);
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
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
