package dfs_bfs.solution126;

import java.util.*;

public class FindLadders {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> form = new HashMap<>();
    Map<String, Integer> steps = new HashMap<>();
    Queue<String> queue = new LinkedList<>();

    int step = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        steps.put(beginWord, 0);
        dict.remove(beginWord);
        queue.add(beginWord);
        boolean found = bfs(dict, beginWord, endWord);
        if (found) {
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(beginWord, endWord,path);
        }
        return ans;
    }

    private void dfs(String beginWord, String cur, Deque<String> path) {
        if (beginWord.equals(cur)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String s : form.get(cur)) {
            path.addFirst(s);
            dfs(beginWord, s, path);
            path.removeFirst();
        }
    }

    private boolean bfs(Set<String> dict, String beginWord, String endWord) {
        int wordLen = beginWord.length();
        boolean found = false;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                for (int i = 0; i < wordLen; i++) {
                    char[] curCharArray = cur.toCharArray();
                    char curChar = curCharArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        curCharArray[i] = j;
                        String nextTmp = new String(curCharArray);
                        if (steps.containsKey(nextTmp) && steps.get(nextTmp) == step) {
                            form.get(nextTmp).add(cur);
                        }
                        if (!dict.contains(nextTmp)) {
                            continue;
                        }
                        queue.add(nextTmp);
                        steps.put(nextTmp, step);
                        dict.remove(nextTmp);
                        form.putIfAbsent(nextTmp, new ArrayList<>());
                        form.get(nextTmp).add(cur);
                        if (nextTmp.equals(endWord)) {
                            found = true;
                        }
                        curCharArray[i] = curChar;
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(findLadders.findLadders("hit", "cog", Arrays.asList(wordList)));
    }
}
