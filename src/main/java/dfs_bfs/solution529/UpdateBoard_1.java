package dfs_bfs.solution529;

public class UpdateBoard_1 {
	int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

	public char[][] updateBoard(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
		} else if (board[click[0]][click[1]] == 'E') {
			bfs(board, click);
		}
		return board;

	}

	private void bfs(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];
		int cur = 0;

		for (int i = 0; i < 8; i++) {
			int nextX = dirX[i] + x;
			int nextY = dirY[i] + y;
			if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length) {
				continue;
			}
			if (board[nextX][nextY] == 'M') {
				cur++;
			}
		}
		if (cur > 0) {
			board[x][y] = (char) ('0' + cur);
		} else {
			board[x][y] = 'B';
			for (int i = 0; i < 8; i++) {
				int nextX = dirX[i] + x;
				int nextY = dirY[i] + y;
				if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length
						|| board[nextX][nextY] != 'E') {
					continue;
				}
				bfs(board, new int[]{nextX, nextY});
			}
		}

	}

}
