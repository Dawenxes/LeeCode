package divide_conquer.solution37;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 解数独
 * @ClassName: SolveSudoku
 * @Author: zbn
 * @Date: 2021/7/16 15:24o
 */
public class SolveSudoku {
    boolean[][] line = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] box = new boolean[3][3][9];
    List<int[]> list = new ArrayList<>();
    private boolean valid = false;

    public boolean solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    line[i][c] = true;
                    column[j][c] = true;
                    box[i / 3][j / 3][c] = true;
                } else {
                    list.add(new int[]{i, j});
                }
            }
        }
        _dfs(board, 0);
        return valid;
    }

    private void _dfs(char[][] board, int pos) {
        if (pos == list.size()) {
            valid = true;
            return;
        }
        int[] cur = list.get(pos);
        for (int i = 0; i < 9 && !valid; i++) {
            int r = cur[0];
            int c = cur[1];
            if (!line[r][i] && !column[c][i] && !box[r / 3][c / 3][i]) {
                line[r][i] = column[c][i] = box[r / 3][c / 3][i] = true;
                board[r][c] = (char) ('1' + i);
                _dfs(board, pos + 1);
                line[r][i] = column[c][i] = box[r / 3][c / 3][i] = false;
            }
        }
    }
}
