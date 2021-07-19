package dfs_bfs.solution433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinMutation_1 {
    char[] mode = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> map = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(start);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(end);

        if (!map.contains(end)) {
            return -1;
        }

        int beginLen = 0;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            beginLen += 1;
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            HashSet<String> nextLevelVisited = new HashSet<>();
            for (String cur : beginVisited) {
                if (changeWordEveryOneLetter(cur, endVisited, visited, map, nextLevelVisited)) {
                    return beginLen;
                }
            }
            if (nextLevelVisited.isEmpty()) {
                return -1;
            }
            beginVisited = nextLevelVisited;

        }
        return beginLen;
    }


    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     *
     * @param word
     * @param endVisited
     * @param visited
     * @param wordSet
     * @param nextLevelVisited
     * @return
     */
    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited,
                                             Set<String> visited,
                                             Set<String> wordSet,
                                             Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c : mode) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复，下次再用
            charArray[i] = originChar;
        }
        return false;
    }
}
