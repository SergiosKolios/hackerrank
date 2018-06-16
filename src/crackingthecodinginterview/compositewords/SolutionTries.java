package crackingthecodinginterview.compositewords;

import java.util.Map;
import java.util.Set;

/**
 * Given a two word arrays one of thesaurus (e.g. {"air", "ball", "basket", balloon", "pit", "dog", "fall"}
 * & composite array {"airplane", "basketball", "drill", "mombasa"}
 * find which of the words in the second array are composed of parts of the first array
 * The challenge can become even better if a word in the composite array is created by more than two words of
 * the thesaurus
 *
 * // Trie Solution for only 2 composite compound words
 * */

public class SolutionTries {

    static boolean isCompoundWord(String candidate, Trie thesaurus) {

        if (candidate.isEmpty() || thesaurus.isEmpty()) {
            return false;
        }

        for (int i = 1; i < candidate.length(); i++) {

            String firstCompound = candidate.substring(0, i);
            String secondCompound = candidate.substring(i, candidate.length());

            boolean firstFound = thesaurus.find(firstCompound);
            boolean secondFound = thesaurus.find(secondCompound);

            if (firstFound && secondFound) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] thesaurusArray = {"air", "arm", "basket", "balloon", "pit", "ball", "dog", "fall"};
        String[] compositeArray = {"airballoondog", "armpit", "airplane", "basketball", "drill", "mombasa"};

        Trie trie = new Trie();

        for (String w : thesaurusArray) {
            trie.insert(w);
        }

        for (String word : compositeArray) {
            boolean isCompound = isCompoundWord(word, trie);
            System.out.println("Word \"" + word + "\" is a compound word: " + isCompound);
        }
    }
}
