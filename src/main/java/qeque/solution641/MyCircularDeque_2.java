package qeque.solution641;

public class MyCircularDeque_2 {

  int capacity;
  int[] array;
  int front;
  int last;
  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque_2(int k) {
    array = new int[k + 1];
    capacity = k + 1;
    front = 0;
    last = 0;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    array[front] = value;
    front = (front + 1) % capacity;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    last = last == 0 ? (capacity - 1) : (last - 1);
    array[last] = value;
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

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    last = (last + 1) % capacity;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    if (isEmpty()) {
    return -1;
  }

    return array[front == 0 ? (capacity - 1) : (front - 1)];
  }

  /** Get the last item from the deque. */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return array[last];
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return last == front;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return (front + 1) % capacity == last;
  }
}
