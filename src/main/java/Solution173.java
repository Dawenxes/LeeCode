import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution173 {
  public static void main(String[] args) {}

  /** Definition for a binary tree node. */
  class BSTIterator {

    private TreeNode cur = null;
    private Deque<TreeNode> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
      this.cur = root;
    }

    public int next() {
      while (cur != null) {
        list.push(cur);
        cur = cur.left;
      }
      cur = list.poll();
      int result = cur.val;
      cur = cur.right;
      return result;
    }

    public boolean hasNext() {
      return cur != null || !list.isEmpty();
    }
  }
}
