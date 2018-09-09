package datastructures.Tries.Contacts;

import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class TrieTest {

    @Test
    public void testStringTokenizer() {
        String phrase = "All work and no game makes Sergios A dull boy";
        StringTokenizer tokenizer = new StringTokenizer(phrase);
        while (tokenizer.hasMoreElements()){
            System.out.println("\n" + tokenizer.nextToken());
        }
    }

    @Test
    public void testIntCharacter() throws InterruptedException {
        for (int i = 32; i < 128; i++) {
            int var = i;
            char c = (char)var;
            System.out.println("Int: " + i + " - Char: " + c);
            Thread.sleep(100);
        }
    }

    @Test
    public void addWordsToTrie() {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cat");
    }

}
