package divide_conquer.solution980;

public class UniquePathsIII_1 {
	int[] dr = new int[]{0, -1, 0, 1};
	int[] dc = new int[]{1, 0, -1, 0};
	int R, C;
	int sr, sc;
	int tr, tc;
	int ans = 0;
	int todo = 0;

	public int uniquePathsIII(int[][] grid) {
		R = grid.length;
		C = grid[0].length;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					sr = i;
					sc = j;
				} else if (grid[i][j] == 2) {
					tr = i;
					tc = j;
				}
				if (grid[i][j] != -1) {
					todo++;
				}
			}
		}
		dfs(grid, sr, sc);
		return ans;
	}

	private void dfs(int[][] grid, int r, int c) {
		if (r == tr && c == tc) {
			if (todo == 1) {
				ans += 1;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextC < 0 || nextC >= C || nextR >= R) {
				continue;
			}
			int next = grid[nextR][nextC];
			int cur = grid[r][c];
			if (next == -1 || next == 3 || next == 1) {
				continue;
			}
			grid[r][c] = 3;
			todo--;
			dfs(grid, nextR, nextC);
			grid[r][c] = cur;
			todo++;
		}
	}

}
