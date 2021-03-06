package qeque.solution42;

import java.util.Deque;
import java.util.LinkedList;

public class TrapByStack_2 {
  public int trap(int[] height) {
    int ans = 0;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        Integer top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        Integer left = stack.peek();
        int currentHeight = Math.min(height[left], height[i]) - height[top];
        ans += currentHeight * (i - left - 1);
      }
      stack.push(i);
    }
    return ans;
  }
}
