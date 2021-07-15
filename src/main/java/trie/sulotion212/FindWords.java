package trie.sulotion212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangBoneng
 */
public class FindWords {
    List<String> ans = new ArrayList<>();
    int[] dm = {1, 0, -1, 0};
    int[] dn = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        // 1. 构建树
        TrieNode parent = buildTrie(words);

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (parent.children.containsKey(board[i][j])) {
                    _dfs(i, j, parent, board);
                }
            }
        }
        return ans;
    }

    private void _dfs(int m, int n, TrieNode parent, char[][] board) {
        char cur = board[m][n];
        TrieNode currNode = parent.children.get(cur);
        if (currNode.word != null) {
            ans.add(currNode.word);
            currNode.word = null;
        }
        board[m][n] = '#';
        for (int i = 0; i < 4; i++) {
            int nextM = m + dm[i];
            int nextN = n + dn[i];
            if (nextM < 0 || nextM >= board.length || nextN < 0 || nextN >= board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(board[nextM][nextN])) {
                _dfs(nextM, nextN, currNode, board);
            }
        }
        board[m][n] = cur;
        if (currNode.children.isEmpty()) {
            parent.children.remove(cur);
        }

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode trieNode = new TrieNode();
        for (String word : words) {
            TrieNode parent = trieNode;
            for (char c : word.toCharArray()) {
                if (!parent.children.containsKey(c)) {
                    parent.children.put(c, new TrieNode());
                }
                parent = parent.children.get(c);
            }
            parent.word = word;
        }
        return trieNode;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = null;
        }
    }

}