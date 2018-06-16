package crackingthecodinginterview.compositewords;

/*
 * Source: http://www.baeldung.com/trie-java
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {

    @Test
    void givenATrie_WhenAddingElements_ThenTrieContainsThoseElements() {
        Trie trie = createExampleTrie();

        assertFalse(trie.find("3"));
        assertFalse(trie.find("vida"));
        assertTrue(trie.find("life"));
    }

    @Test
    void whenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        Trie trie = createExampleTrie();

        assertTrue(trie.find("Programming"));

        String candidate = "Programming";

        trie.delete(candidate);
        assertFalse(trie.find(candidate));
    }


    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("Paw");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        trie.insert("pot");

        return trie;
    }

}
