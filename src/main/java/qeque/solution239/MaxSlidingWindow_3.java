package qeque.solution239;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_3 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int[] ans = new int[nums.length - k + 1];
		// 求ans[0]
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
				deque.pollFirst();
			}
			deque.offerFirst(i);
		}
		ans[0] = nums[deque.peekLast()];
		for (int i = k; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
				deque.pollFirst();
			}
			deque.offerFirst(i);
			while (deque.peekLast() < i - k + 1) {
				deque.pollLast();
			}
			ans[i - k + 1] = nums[deque.peekLast()];
		}
		return ans;
	}
}
