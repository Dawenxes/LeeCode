package competition.solution5791;

public class CountSubIslands {
  int xLength, yLength;
  int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  int ans = 0;
  public int countSubIslands(int[][] grid1, int[][] grid2) {
    xLength = grid1[0].length;
    yLength = grid1.length;
    for (int y = 0; y < grid1.length; y++) {
      for (int x = 0; x < grid1[x].length; x++) {
        if (grid1[y][x] == 1) {
          _dfs(grid1, grid2, y, x);
        }
      }
    }
    return ans;
  }

  private boolean _dfs(int[][] grid1, int[][] grid2, int y, int x) {
    if (grid1[y][x] == 0 && grid2[y][x] == 1) {

      return false;
    }

    if (grid1[y][x] == 1) {
      grid1[y][x] = 0;
      grid2[y][x] = 0;
      for (int k = 0; k < 4; k++) {
        if (y + dirs[k][0] >= 0
            && y + dirs[k][0] < yLength
            && x + dirs[k][1] >= 0
            && x + dirs[k][1] < xLength) {
         return  _dfs(grid1, grid2, y + dirs[k][0], x + dirs[k][1]);
        }
      }
    }
    return true;
  }
}
