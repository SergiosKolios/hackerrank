package crackingthecodinginterview.compositewords;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a two word arrays one of thesaurus (e.g. {"air", "ball", "basket", balloon", "pit", "dog", "fall"}
 * & composite array {"airplane", "basketball", "drill", "mombasa"}
 * find which of the words in the second array are composed of parts of the first array
 * The challenge can become even better if a word in the composite array is created by more than two words of
 * the thesaurus
 *
 * // Probable "proper" solution is Trie implementation but this looks like it's working
 * */

public class Solution {

    static boolean isCompoundWord(String candidate, Set<String> thesaurus) {

        boolean result = false;

        if (thesaurus.isEmpty()) {
            return result;
        }

        for (String word : thesaurus) {
            if (candidate.startsWith(word)) {
                String secondComposite = candidate.substring(word.length(), candidate.length());
                if (thesaurus.contains(secondComposite)) {
                    result = true;
                    return result;
                }
                else {
                    result = isCompoundWord(secondComposite, thesaurus);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] thesaurusArray = {"air", "arm", "basket", "balloon", "pit", "ball", "dog", "fall"};
        String[] compositeArray = {"airballoondog", "armpit", "airplane", "basketball", "drill", "mombasa"};

        for (String word : compositeArray) {
            boolean isCompound = isCompoundWord(word, new TreeSet<>(Arrays.asList(thesaurusArray)));
            System.out.println("Word \"" + word + "\" is a compound word: " + isCompound);
        }
    }
}
