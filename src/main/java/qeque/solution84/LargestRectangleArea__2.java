package qeque.solution84;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea__2 {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new LinkedList<>();
    int[] left = new int[heights.length];
    int[] right = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        right[stack.peek()] = i;
        stack.pop();
      }
      left[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
    }
    return result;
  }
}
