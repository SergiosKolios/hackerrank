package crackingthecodinginterview.compositewords;

/*
 * Source: http://www.baeldung.com/trie-java
 */

class Trie {

    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    // O(n) insertion complexity
    void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.setEndOfWord(true);

    }

    // O(n) search complexity, where n is the length of the word
    boolean find(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return this.root.isEmpty();
    }

    void delete(String word) {
        delete(this.root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}
