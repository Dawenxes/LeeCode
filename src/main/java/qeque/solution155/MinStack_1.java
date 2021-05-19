package qeque.solution155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_1 {

  Deque<Integer> xStack = new LinkedList<>();
  Deque<Integer> minStack = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack_1() {
    minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
    minStack.push(Math.min(val, minStack.peek()));
    xStack.push(val);
    }

  public void pop() {
    minStack.pop();
    xStack.pop();
  }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
    return minStack.peek();
    }
}
