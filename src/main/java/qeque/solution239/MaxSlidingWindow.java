package qeque.solution239;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();
		int i = 0;
		for (; i < k; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}
		result[0] = nums[deque.peekFirst()];
		for (; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			while (deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}
			result[i - k + 1] = nums[deque.peekFirst()];
		}
		return result;
	}
}
