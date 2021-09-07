package qeque.solution84;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea__3 {
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new LinkedList<>();
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				right[stack.peek()] = i;
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		for (int i = 0; i < heights.length; i++) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}
		return ans;
	}
}
