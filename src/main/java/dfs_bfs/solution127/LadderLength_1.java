package dfs_bfs.solution127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LadderLength_1 {
  Map<String, Integer> map = new HashMap<>();
  List<List<Integer>> edge = new ArrayList<>();
  int nodeNum = 0;
  Queue<Integer> queue = new LinkedList<>();

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 准备工作
    for (String s : wordList) {
      addEdge(s);
    }
    if (!map.containsKey(endWord)) {
      return -1;
    }
    addEdge(beginWord);
    int[] dis = new int[nodeNum];
    Arrays.fill(dis, Integer.MAX_VALUE);
    int beginWordIndex = map.get(beginWord);
    int endWordIndex = map.get(endWord);
    dis[beginWordIndex] = 0;
    queue.add(beginWordIndex);
    while (!queue.isEmpty()) {
      int index = queue.poll();
      if (index == endWordIndex) {
        return dis[endWordIndex] / 2 + 1;
      }
      List<Integer> edgeNode = edge.get(index);
      for (Integer s : edgeNode) {
        if (dis[s] == Integer.MAX_VALUE) {
          dis[s] = dis[index] + 1;
          queue.offer(s);
        }
      }
    }
    return 0;
  }

  private void addEdge(String s) {

  }

  private void addWord(String s) {

  }
}
