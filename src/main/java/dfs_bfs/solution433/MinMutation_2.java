package dfs_bfs.solution433;

import java.util.*;

public class MinMutation_2 {
	char[] mode = {'A', 'C', 'G', 'T'};

	public int minMutation(String start, String end, String[] bank) {
		int ans = 0;

		Map<String, Integer> map = new HashMap<>();
		for (String s : bank) {
			map.put(s, 0);
		}
		if (!map.containsKey(end)) {
			return -1;
		}
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int ik = 0; ik < size; ik++) {
				String poll = queue.poll();
				char[] chars = poll.toCharArray();
				if (poll.equals(end)) {
					return ans;
				}
				for (int i = 0; i < chars.length; i++) {
					char cur = chars[i];
					for (int j = 0; j < mode.length; j++) {
						chars[i] = mode[j];
						String next = new String(chars);
						if (map.containsKey(next) && !visited.contains(next)) {
							queue.add(next);
							visited.add(next);
						}
						chars[i] = cur;
					}
				}
			}
			ans++;
		}
		return -1;
	}

}
