package dfs_bfs.solution126;

import java.util.*;

public class FindLadders_1 {
    List<List<String>> ans = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    Map<String, Integer> wordWithStep = new HashMap<>();
    Map<String, List<String>> form = new HashMap<>();
    int step = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) {
            return ans;
        }
        boolean isFound = false;
        queue.add(beginWord);
        wordWithStep.put(beginWord, step++);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] curChars = cur.toCharArray();
                for (int j = 0; j < curChars.length; j++) {
                    char tmpChar = curChars[j];
                    for (int k = 'a'; k <= 'z'; k++) {
                        curChars[j] = (char) k;
                        String next = new String(curChars);
                        if (wordWithStep.containsKey(next) && wordWithStep.get(next) == step) {
                            form.get(next).add(cur);
                        }
                        if (!dict.contains(next)) {
                            continue;
                        }
                        form.putIfAbsent(next, new ArrayList<>());
                        form.get(next).add(cur);
                        wordWithStep.put(next, step);
                        dict.remove(next);
                        queue.add(next);
                        if (endWord.equals(next)) {
                            isFound = true;
                        }
                    }
                    curChars[j] = tmpChar;
                }

            }
            step++;
            if (isFound) {
                break;
            }
        }
        if (isFound) {
            Deque<String> path = new LinkedList<>();
            path.addFirst(endWord);
            _dfs(path, endWord, beginWord);
        }
        return ans;
    }

    private void _dfs(Deque<String> path, String endWord, String beginWord) {
        if (beginWord.equals(path.peekFirst())) {
            ans.add(new ArrayList<>(path));
            return;
        }
        List<String> pres = form.get(endWord);
        for (String pre : pres) {
            path.addFirst(pre);
            _dfs(path, pre, beginWord);
            path.removeFirst();
        }
    }


    public static void main(String[] args) {
        FindLadders_1 findLadders = new FindLadders_1();
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(findLadders.findLadders("hit", "cog", Arrays.asList(wordList)));
    }
}
