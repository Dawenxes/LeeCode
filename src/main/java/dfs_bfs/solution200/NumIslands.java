package dfs_bfs.solution200;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int numIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * nc + j);
                    while (!queue.isEmpty()) {
                        Integer dir = queue.poll();
                        int row = dir / nc;
                        int col = dir % nc;
                        grid[row][col] = '0';
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            queue.add((row-1) * nc + col);
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            queue.add((row+1) * nc + col);
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            queue.add(row * nc + col-1);
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            queue.add(row * nc + col+1);
                        }
                    }
                }
            }
        }
        return num;
    }
}
