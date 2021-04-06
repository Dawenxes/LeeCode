import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution1006 {
  public int clumsy(int N) {
    Deque<Integer> stack = new LinkedList();
    stack.push(N);
    N--;
    int index = 0;
    while (N > 0) {
      if (index % 4 == 0) {
        stack.push(stack.pop() * N);
      } else if (index % 4 == 1) {
        stack.push(stack.pop() / N);
      }else if (index % 4 == 2) {
        stack.push(N);
      }else {
        stack.push(-N);
      }
      N--;
      index++;
    }
    // 把栈中所有的数字依次弹出求和
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }

  public static void main(String[] args) {
    Solution1006 solution75 = new Solution1006();
    System.out.println(solution75.clumsy(10));

  }
}
