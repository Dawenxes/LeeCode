/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution52 {


    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {

                int position = availablePositions & (-availablePositions);//lowestBit
                availablePositions = availablePositions & (availablePositions - 1);// 最低1位 置0
                count += solve(n, row + 1, columns | position, (diagonals1 | position) >> 1,
                               (diagonals2 | position) << 1);
            }
            return count;
        }
    }


    public static void main(String[] args) {
        Solution52 solution75 = new Solution52();
        System.out.println(solution75.totalNQueens(4));
    }


}
