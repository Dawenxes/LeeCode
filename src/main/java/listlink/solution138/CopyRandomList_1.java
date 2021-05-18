package listlink.solution138;

import common.RandomNode;

import java.util.HashMap;

public class CopyRandomList_1 {
  HashMap<RandomNode, RandomNode> randomNodeRandomNodeHashMap = new HashMap<>();

  // 递归
  public RandomNode copyRandomList_1(RandomNode head) {
    if (head == null) {
      return null;
    }
    if (randomNodeRandomNodeHashMap.containsKey(head)) {
      return randomNodeRandomNodeHashMap.get(head);
    }
    RandomNode randomNode = new RandomNode(head.val, null, null);
    randomNodeRandomNodeHashMap.put(head, randomNode);
    randomNode.next = this.copyRandomList_1(head.next);
    randomNode.random = this.copyRandomList_1(head.random);
    return randomNode;
  }
}
