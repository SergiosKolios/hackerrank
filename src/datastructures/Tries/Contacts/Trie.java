package datastructures.Tries.Contacts;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        root.addWord(word);
    }

}
