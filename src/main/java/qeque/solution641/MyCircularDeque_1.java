package qeque.solution641;

public class MyCircularDeque_1 {
  int capacity;
  int front;
  int last;
  int[] arr;
  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque_1(int k) {
    arr = new int[k + 1];
    front = 0;
    last = 0;
    capacity = k + 1;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    front = (front - 1 + capacity) % capacity;
    arr[front] = value;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    arr[last] = value;
    last = (last + 1) % capacity;
    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    front = (front + 1 ) % capacity;
    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    last = (last - 1 + capacity) % capacity;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return arr[front];
  }

  /** Get the last item from the deque. */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return arr[(last - 1 + capacity) % capacity];
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return last == front;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return (last + 1) % capacity == front;
  }
}
