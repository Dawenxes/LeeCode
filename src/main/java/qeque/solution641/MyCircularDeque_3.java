package qeque.solution641;

public class MyCircularDeque_3 {
	int capacity;
	int front;
	int end;
	int[] values;


	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque_3(int k) {
		capacity = k + 1;
		values = new int[k + 1];
		front = 0;
		end = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}
		values[front] = value;
		front = (front + 1) % capacity;
		return true;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return (front + 1) % capacity == end;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}
		end = end == 0 ? (capacity - 1) : (end - 1);
		values[end] = value;
		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		front = front == 0 ? (capacity - 1) : (front - 1);
		return true;
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return end == front;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		end = (end + 1) % capacity;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (isEmpty()) {
			return -1;
		}
		return values[front == 0 ? (capacity - 1) : (front - 1)];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		if (isEmpty()) {
			return -1;
		}
		return values[end];
	}
}
