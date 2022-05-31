package dynamic.solution85;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 最大矩形 @ClassName: MaximalRectangle @Author: zbn @Date: 2021/8/4 11:23
 */
public class MaximalRectangle2 {
  public static void main(String[] args) {
    MaximalRectangle2 maximalRectangle = new MaximalRectangle2();
    System.out.println(
        maximalRectangle.maximalRectangle(
            new char[][] {
              {'1', '0', '1', '0', '0'},
              {'1', '0', '1', '1', '1'},
              {'1', '1', '1', '1', '1'},
              {'1', '0', '0', '1', '0'}
            }));
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;

    int[][] mm = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          mm[i][j] = (j == 0) ? 1 : (mm[i][j - 1] + 1);
        } else {
          mm[i][j] = 0;
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int[] down = new int[m];
      int[] up = new int[m];
      LinkedList<Integer> stack=new LinkedList<>();
      for (int j = 0; j < m; j++) {
        while (!stack.isEmpty() && mm[j][i] <= mm[stack.peek()][i]) {
          stack.pop();
        }
        up[j] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(j);
      }
      stack.clear();
      for (int j = m-1; j >= 0; j--) {
        while (!stack.isEmpty() && mm[j][i] <= mm[stack.peek()][i]) {
          stack.pop();
        }
        down[j] = stack.isEmpty() ? m : stack.peek();
        stack.push(j);
      }
      for (int j = 0; j < m; j++) {
        int height = down[j] - up[j] - 1;
        int area = height * mm[j][i];
        ans = Math.max(ans, area);
      }

    }
    return ans;
  }

}
