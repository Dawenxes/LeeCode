package dynamic.solution980;

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
        return ans;
    }
}
