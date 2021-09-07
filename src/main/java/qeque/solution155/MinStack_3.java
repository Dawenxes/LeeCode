package qeque.solution155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_3 {
	Deque<Integer> normal = new LinkedList<>();
	Deque<Integer> minStack = new LinkedList<>();

	/** initialize your data structure here. */
	public MinStack_3() {
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int val) {
		normal.push(val);
		minStack.push(Math.min(minStack.peek(), val));
	}

	public void pop() {
		normal.pop();
		minStack.pop();
	}

	public int top() {
		return normal.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
