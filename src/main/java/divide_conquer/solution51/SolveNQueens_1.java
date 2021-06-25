package divide_conquer.solution51;

import java.util.*;

public class SolveNQueens_1 {
    Set<Integer> column = new HashSet<>();
    Set<Integer> dis1 = new HashSet<>();
    Set<Integer> dis2 = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        _dfs(n);
        return ans;

    }
    private void _dfs(int n) {
        int row = column.size();
        if (row== n) {
            fillList(new ArrayList<Integer>(stack),n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!column.contains(i)&&!dis1.contains(row + i)&&!dis2.contains(i - row)) {
                column.add(i);
                dis1.add(row + i);
                dis2.add(i - row);
                stack.push(i);
                _dfs(n);
                stack.pop();
                column.remove(i);
                dis1.remove(row + i);
                dis2.remove(i - row);
            }
        }
    }

    private void fillList(ArrayList<Integer> column, int n) {
        List<String> strings = new ArrayList<>();
        column.stream().forEach(integer -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == integer) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            strings.add(stringBuilder.toString());
        });
        ans.add(strings);
    }

    public static void main(String[] args) {
        SolveNQueens_1 solveNQueens_1 = new SolveNQueens_1();
        List<List<String>> lists = solveNQueens_1.solveNQueens(4);
        System.out.println(Arrays.deepToString(lists.toArray()));
    }
}
