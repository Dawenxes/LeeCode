package qeque.solution84;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea_4 {
  public static void main(String[] args) {
    LargestRectangleArea_4 largestRectangleArea_4 = new LargestRectangleArea_4();
    System.out.println(largestRectangleArea_4.largestRectangleArea(new int[] {2,3}));
  }
  // 枚举
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new LinkedList<>();

    int ans = 0;
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        Integer pop = stack.pop();
        ans = Math.max(heights[pop] * (i - (stack.isEmpty() ? -1 : stack.peek())-1), ans);
      }
      stack.push(i);
    }
    int pre = heights.length;
    while (!stack.isEmpty()) {
      Integer pop = stack.pop();
      ans = Math.max(ans, heights[pop] * (pre - (stack.isEmpty() ? -1 : stack.peek())-1));
    }
    return ans;
  }
}
