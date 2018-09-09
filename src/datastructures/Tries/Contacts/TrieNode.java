package datastructures.Tries.Contacts;


public class TrieNode {

    TrieNode parent;
    TrieNode[] children;
    char value;
    boolean endOfWord;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
        endOfWord = false;
    }

    public TrieNode(char character) {
        this.value = character;
        children = new TrieNode[26];
        isLeaf = true;
        endOfWord = false;
    }

    public void addWord(String word) {
        isLeaf = false;

        // Create a new Node in position of letter
        int charPos = word.charAt(0) - 'a';
        if (children[charPos] == null) {
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }

        if (word.length() > 1) {
            children[charPos].addWord(word.substring(1));
        } else {
            children[charPos].endOfWord = true;
        }
    }

}
