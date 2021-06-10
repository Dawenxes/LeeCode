package divide_conquer.solution51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens {
  Set<Integer> column = new HashSet<>();
  Set<Integer> dis1 = new HashSet<>();
  Set<Integer> dis2 = new HashSet<>();
  List<List<String>> ans = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    int[] queens = new int[n];
    Arrays.fill(queens, -1);
    _dfs(queens, n,0);
    return ans;
  }

  private void _dfs(int[] queens, int n,int k) {
    if (queens[n - 1] != -1) {
      List<String> strings = generateBoard(queens, n);
      ans.add(strings);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (column.contains(i)) {
        continue;
      }
      int dis11= i-k;
      if (dis1.contains(dis11)) {
        continue;
      }
      int dis12 = i + k;
      if (dis2.contains(dis12)) {
        continue;
      }
      queens[k] = i;
      column.add(i);
      dis1.add(dis11);
      dis2.add(dis12);
      _dfs(queens, n, k + 1);
      column.remove(i);
      dis1.remove(dis11);
      dis2.remove(dis12);
      queens[k] = -1;
    }
  }

  public List<String> generateBoard(int[] queens, int n) {
    List<String> board = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      char[] row = new char[n];
      Arrays.fill(row, '.');
      row[queens[i]] = 'Q';
      board.add(new String(row));
    }
    return board;
  }
}
