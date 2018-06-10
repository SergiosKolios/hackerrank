package crackingthecodinginterview.hashtables_ransomnote;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<String, Integer> wordCountMap = new HashMap<>();

    private static void checkMagazine(String[] magazine, String[] note) {
        fillMap(magazine);

        for (String noteWord : note) {
            if (wordCountMap.containsKey(noteWord) && wordCountMap.get(noteWord) >= 1) {
                int wordCount = wordCountMap.get(noteWord);
                wordCountMap.put(noteWord, wordCount - 1);
            }
            else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    // WordCount of a String Array
    private static void fillMap(String[] wordArray) {
        for (String word : wordArray) {
            int wordCount = 1;
            if (wordCountMap.containsKey(word)){
                wordCount += wordCountMap.get(word);
            }
            wordCountMap.put(word, wordCount);
        }
    }

    public static void main(String[] args) {

        String magazineString = "two times three is not four";
        String noteString = "two times two is four";

        String[] magazineWordArray = magazineString.split(" ");
        String[] noteWordArray = noteString.split(" ");

        checkMagazine(magazineWordArray, noteWordArray);

    }
}
