package divide_conquer.solution37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 解数独
 * @ClassName: SolveSudoku
 * @Author: zbn
 * @Date: 2021/7/16 15:24o
 */
public class SolveSudoku_2 {
	boolean[][] line = new boolean[9][9];
	boolean[][] column = new boolean[9][9];
	boolean[][][] box = new boolean[3][3][9];
	List<int[]> list = new ArrayList<>();
	private boolean valid = false;

	public static void main(String[] args) {
		String str = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入字符串");
		str = scan.nextLine();
		char[] charArray = str.toCharArray();
		combine(charArray, 0);
	}

	public static void combine(char[] charArray, int begin) {
		if (begin == charArray.length - 1) {
			System.out.println(String.valueOf(charArray));
		}
		for (int i = begin; i < charArray.length; i++) {
			swap(charArray, begin, i);
			combine(charArray, begin + 1);
			swap(charArray, begin, i);
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char stem = arr[i];
		arr[i] = arr[j];
		arr[j] = stem;
	}

	public void solveSudoku(char[][] board) {

		// 初始化
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				Integer integer = c - '1';
				if (c != '.') {
					line[i][integer] = true;
					column[j][integer] = true;
					box[i / 3][j / 3][integer] = true;
				} else {
					list.add(new int[]{i, j});
				}
			}
		}
		dfs(board, 0);
	}

	private void dfs(char[][] board, int ceng) {
		if (ceng == list.size()) {
			valid = true;
			return;
		}
		int[] ints = list.get(ceng);
		for (int j = 0; j < 9 && !valid; j++) {
			if (line[ints[0]][j] || column[ints[1]][j] || box[ints[0] / 3][ints[1] / 3][j]) {
				continue;
			}
			line[ints[0]][j] = true;
			column[ints[1]][j] = true;
			box[ints[0] / 3][ints[1] / 3][j] = true;
			board[ints[0]][ints[1]] = (char) (j + '1');
			dfs(board, ceng + 1);
			line[ints[0]][j] = false;
			column[ints[1]][j] = false;
			box[ints[0] / 3][ints[1] / 3][j] = false;
		}
	}

}
