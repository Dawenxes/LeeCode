package qeque.solution155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_2 {

  Deque<Integer> deque = new LinkedList<>();
  Deque<Integer> minStack = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack_2() {
      minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
      deque.push(val);
      minStack.push(Math.min(minStack.peek(), val));
    }

  public void pop() {
    deque.pop();
    minStack.pop();
  }

    public int top() {
      return deque.peek();
    }

    public int getMin() {
      return minStack.peek();
    }
}
