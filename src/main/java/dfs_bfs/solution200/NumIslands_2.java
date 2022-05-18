package dfs_bfs.solution200;

public class NumIslands_2 {
	public int numIslands(char[][] grid) {
		int ans = 0;
		if (grid == null) {
			return 0;
		}
		int r = grid.length;
		int c = grid[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == '1') {
					ans++;
					dfs(i, j, grid, r, c);
				}
			}
		}
		return ans;
	}

	private void dfs(int i, int j, char[][] grid, int r, int c) {
		if (i < 0 || j < 0 || j == c || i == r || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(i - 1, j, grid, r, c);
		dfs(i + 1, j, grid, r, c);
		dfs(i, j - 1, grid, r, c);
		dfs(i, j + 1, grid, r, c);
	}

}
