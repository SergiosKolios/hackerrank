package crackingthecodinginterview.compositewords;

/*
 * Source: http://www.baeldung.com/trie-java
 */


import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    void setEndOfWord(boolean endOfWord) {
        this.isWord = endOfWord;
    }

    boolean isEndOfWord() {
        return isWord;
    }

    boolean isEmpty() {
        return this.children.isEmpty()
                &&
                this.isWord;
    }
}
