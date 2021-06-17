package dfs_bfs.solution529;

public class UpdateBoard {
    int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;

    }

    private void dfs(char[][] board, int x, int y) {
        int cur = 0;

        for (int i = 0; i < 8; i++) {
            int xTmp = x + dirX[i];
            int yTmp = y + dirY[i];
            if (xTmp < 0 || yTmp < 0 || xTmp >= board.length || yTmp >= board[0].length) {
                continue;
            }
            if (board[xTmp][yTmp] == 'M') {
                cur++;
            }
        }
        if (cur > 0) {
            board[x][y] = (char) ('0' + cur);
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int xTmp = x + dirX[i];
                int yTmp = y + dirY[i];
                if (xTmp < 0 || yTmp < 0 || xTmp >= board.length || yTmp >= board[0].length||board[xTmp][yTmp]!='E') {
                    continue;
                }
                dfs(board, xTmp, yTmp);
            }
        }
    }
}
