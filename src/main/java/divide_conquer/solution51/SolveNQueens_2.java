package divide_conquer.solution51;

import java.util.*;

public class SolveNQueens_2 {
	Set<Integer> column = new HashSet<>();
	Set<Integer> dis1 = new HashSet<>();
	Set<Integer> dis2 = new HashSet<>();
	List<List<String>> ans = new ArrayList<>();
	Deque<Integer> stack = new LinkedList<>();

	public List<List<String>> solveNQueens(int n) {
		int[] queens = new int[n];
		dfs(queens, 0, n);
		return ans;
	}

	private void dfs(int[] queens, int row, int n) {
		if (row == n) {
			List<String> list = generate(queens);
			ans.add(list);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (column.contains(i) || dis1.contains(row + i) || dis2.contains(row - i)) {
				continue;
			}
			column.add(i);
			dis1.add(row + i);
			dis2.add(row - i);
			queens[row] = i;
			dfs(queens, row + 1, n);
			column.remove(i);
			dis1.remove(row + i);
			dis2.remove(row - i);
			queens[row] = -1;
		}
	}

	private List<String> generate(int[] queens) {
		ArrayList<String> strings = new ArrayList<>();
		char[] chars = new char[queens.length];
		Arrays.fill(chars, '.');
		for (int i = 0; i < queens.length; i++) {
			chars[queens[i]] = 'Q';
			String s = new String(chars);
			strings.add(s);
			chars[queens[i]] = '.';
		}
		return strings;
	}
}
