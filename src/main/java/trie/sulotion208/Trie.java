package trie.sulotion208;

public class Trie {
    private Trie[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int n = word.length();
        Trie trie = this;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (trie.children[index] == null) {
                Trie nextTrie = new Trie();
                trie.children[index] = nextTrie;
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = searchPrifix(word);
        return trie != null && trie.isEnd;
    }

    private Trie searchPrifix(String word) {
        int n = word.length();
        Trie trie = this;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (trie.children[index] == null) {
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrifix(prefix) != null;
    }

}