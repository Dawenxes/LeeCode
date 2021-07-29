package bit.solution51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: N 皇后
 * @ClassName: SolveNQueens
 * @Author: zbn
 * @Date: 2021/7/28 23:10
 */

public class SolveNQueens {
    List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));

    }

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        _dfs(queens, 0, 0, 0, 0);
        return result;
    }

    private void _dfs(int[] queens, int row, int columns, int pies, int las) {
        int n = queens.length;

        if (row == n) {
            result.add(solveNQueens(queens));
            return;
        } else {
            int availablePosition = ((1 << n) - 1) & (~(columns | pies | las));
            while (availablePosition > 0) {
                int nextPosition = availablePosition & (-availablePosition);
                availablePosition = availablePosition & (availablePosition - 1);
                int column = Integer.bitCount(nextPosition - 1);
                queens[row] = column;
                _dfs(queens, row + 1, columns | nextPosition, (pies | nextPosition) << 1, (las | nextPosition) >> 1);
                queens[row] = -1;
            }
        }
    }

    private List<String> solveNQueens(int[] queens) {
        List<String> board = new ArrayList<String>();
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;

    }
}
