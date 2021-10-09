package dfs_bfs.solution126;

import java.util.*;

public class FindLadders_2 {
	List<List<String>> ans = new ArrayList<>();

	public static void main(String[] args) {
		FindLadders_2 findLadders = new FindLadders_2();
		String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(findLadders.findLadders("hit", "cog", Arrays.asList(wordList)));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord)) {
			return ans;
		}
		dict.remove(beginWord);
		Queue<String> queue = new LinkedList<>();
		Map<String, List<String>> from = new HashMap<>();
		Map<String, Integer> steps = new HashMap<>();
		int step = 1;
		queue.add(beginWord);
		boolean found = false;
		steps.put(beginWord, 0);
		while (!queue.isEmpty() && !found) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curStr = queue.poll();
				char[] curChars = curStr.toCharArray();
				for (int j = 0; j < curChars.length; j++) {
					char prechar = curChars[j];
					for (char k = 'a'; k <= 'z'; k++) {
						curChars[j] = k;
						String nextStr = new String(curChars);
						if (steps.containsKey(nextStr) && step == steps.get(nextStr)) {
							from.get(nextStr).add(curStr);
						}
						if (!dict.contains(nextStr)) {
							continue;
						}
						dict.remove(nextStr);
						queue.offer(nextStr);
						from.putIfAbsent(nextStr, new ArrayList<String>());
						from.get(nextStr).add(curStr);
						// 记录 nextWord 的 step
						steps.put(nextStr, step);

						if (nextStr.equals(endWord)) {
							found = true;
						}

					}
					curChars[j] = prechar;
				}

			}
			step++;
		}
		if (found) {
			Deque<String> path = new LinkedList<>();
			path.add(endWord);
			dfs(from, beginWord, endWord, ans, path);
		}
		return ans;

	}

	private void dfs(Map<String, List<String>> from, String beginWord, String cur, List<List<String>> ans,
			Deque<String> path) {
		if (cur.equals(beginWord)) {
			ans.add(new ArrayList<>(path));
			return;
		}
		List<String> list = from.get(cur);
		for (String s : list) {
			path.addFirst(s);
			dfs(from, beginWord, s, ans, path);
			path.removeFirst();
		}
	}

}
