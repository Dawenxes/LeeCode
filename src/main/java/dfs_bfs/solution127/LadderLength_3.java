package dfs_bfs.solution127;

import java.util.*;

public class LadderLength_3 {
	Map<String, Integer> map = new HashMap<>();
	List<List<Integer>> edge = new ArrayList<>();
	int nodeNum = 0;
	Queue<Integer> beginQueue = new LinkedList<>();

	public static void main(String[] args) {
		LadderLength_3 ladderLength_1 = new LadderLength_3();
		String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(ladderLength_1.ladderLength("hit", "cog", Arrays.asList(wordList)));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		for (String s : wordList) {
			addEdge(s);
		}
		addEdge(beginWord);
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Integer beginId = map.get(beginWord);
		Integer endID = map.get(endWord);
		beginQueue.add(beginId);
		int[] dis = new int[nodeNum];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[beginId] = 0;
		while (!beginQueue.isEmpty()) {
			int size = beginQueue.size();
			for (int i = size; i > 0; i--) {
				Integer poll = beginQueue.poll();
				if (poll == endID) {
					return dis[endID] / 2 + 1;
				}
				List<Integer> integers = edge.get(poll);
				int di = dis[poll];
				for (int j = 0; j < integers.size(); j++) {
					if (dis[integers.get(j)] == Integer.MAX_VALUE) {
						beginQueue.add(integers.get(j));
						dis[integers.get(j)] = di + 1;
					}
				}
			}
		}
		return 0;
	}

	private void addEdge(String s) {
		addWord(s);
		Integer i1 = map.get(s);
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			char tmp = chars[i];
			chars[i] = '*';
			String s1 = new String(chars);
			addWord(s1);
			Integer i2 = map.get(s1);
			edge.get(i1).add(i2);
			edge.get(i2).add(i1);
			chars[i] = tmp;
		}
	}

	private void addWord(String s) {
		if (!map.containsKey(s)) {
			map.put(s, nodeNum++);
			edge.add(new ArrayList<>());
		}

	}
}
