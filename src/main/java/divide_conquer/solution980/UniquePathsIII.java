package divide_conquer.solution980;

public class UniquePathsIII {
    int br, bc, sr, sc;
    int todo = 0;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int R, C;
    int ans = 0;

    public int uniquePathsIII(int[][] grid) {

        R = grid.length;
        C = grid[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != -1) {
                    todo++;
                }
                if (grid[i][j] == 1) {
                    br = i;
                    bc = j;
                } else if (grid[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }
        _dfs(br, bc, todo - 1, grid);
        return ans;
    }

    private void _dfs(int br, int bc, int todo, int[][] grid) {
        if (br == sr && bc == sc) {
            if (todo == 0) {
                ans++;
            }
            return;
        }
        grid[br][bc] = 3;
        for (int i = 0; i < 4; i++) {
            int nr = br - dr[i];
            int nc = bc - dc[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (grid[nr][nc] % 2 == 0) {
                    _dfs(nr, nc, todo - 1, grid);
                }
            }
        }
        grid[br][bc] = 0;
    }
}
