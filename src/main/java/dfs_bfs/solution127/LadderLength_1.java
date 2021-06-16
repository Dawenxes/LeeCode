package dfs_bfs.solution127;

import java.util.*;

public class LadderLength_1 {
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;
    Queue<Integer> beginQueue = new LinkedList<>();
    Queue<Integer> endQueue = new LinkedList<>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 准备工作
        for (String s : wordList) {
            addEdge(s);
        }
        addEdge(beginWord);
        if (!map.containsKey(endWord)) {
            return 0;
        }
        int beginWordIndex = map.get(beginWord);
        int endWordIndex = map.get(endWord);
        beginQueue.add(beginWordIndex);
        endQueue.add(endWordIndex);
        int beginLen = 0;
        int endLen = 0;
        Boolean[] endVisited = new Boolean[nodeNum];
        Boolean[] beginVisited = new Boolean[nodeNum];
        Arrays.fill(endVisited, false);
        Arrays.fill(beginVisited, false);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int size = beginQueue.size();
            beginLen += 1;
            for (int i = 0; i < size; i++) {
                int index = beginQueue.poll();
                if (endVisited[index]) {
                    return (endLen + beginLen) / 2 ;
                }
                beginVisited[index] = true;
                List<Integer> edgeNode = edge.get(index);
                for (Integer s : edgeNode) {
                    if (!beginVisited[s]) {
                        beginQueue.offer(s);
                    }
                }
            }
            size = endQueue.size();
            endLen += 1;
            for (int i = 0; i < size; i++) {
                int index = endQueue.poll();
                if (beginVisited[index]) {
                    return (endLen + beginLen) / 2 ;
                }
                endVisited[index] = true;
                List<Integer> edgeNode = edge.get(index);
                for (Integer s : edgeNode) {
                    if (!endVisited[s]) {
                        endQueue.offer(s);
                    }
                }
            }
        }
        return 0;
    }

    private void addEdge(String s) {
        addWord(s);
        Integer indexS = map.get(s);
        List<Integer> edgeS = edge.get(indexS);

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char tmp = chars[i];
            chars[i] = '*';
            String s1 = new String(chars);
            addWord(s1);
            chars[i] = tmp;
            Integer indexS1 = map.get(s1);
            List<Integer> edgeS1 = edge.get(indexS1);
            edgeS.add(indexS1);
            edgeS1.add(indexS);
        }
    }

    private void addWord(String s) {
        if (!map.containsKey(s)) {
            map.put(s, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        LadderLength_1 ladderLength_1 = new LadderLength_1();
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength_1.ladderLength("hit", "cog", Arrays.asList(wordList)));
    }
}
