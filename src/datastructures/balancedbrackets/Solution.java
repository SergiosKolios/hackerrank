package datastructures.balancedbrackets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    private static Map<Character, Character> matchingCharacters = new HashMap<>();

    static {
        matchingCharacters.put('{', '}');
        matchingCharacters.put('[', ']');
        matchingCharacters.put('(', ')');
    }

    private static boolean isBalanced(String s) {
        // Quick exit if the string is null or empty
        if (s == null || s.isEmpty()) {
            return true;
        }
        // Stack of previous brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through the String characters
        for (char currentCharacter : s.toCharArray()) {
            // case of an opening character, add to stack last element
            if (matchingCharacters.containsKey(currentCharacter)) {
                stack.push(currentCharacter);
                continue;
            }

            // case of a closing character
            if (matchingCharacters.values().contains(currentCharacter)) {
                // if the stack is empty and characters are still left
                if (stack.empty()) {
                    return false;
                }
                // Get the last character of the stack
                char openChar = stack.pop();
                if (!charactersMatch(openChar, currentCharacter)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private static boolean charactersMatch(char c1, char c2) {
        if (! matchingCharacters.containsKey(c1) ){
            return false;
        }
        return matchingCharacters.get(c1) == c2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File inFilePath = new File(currentDir + "/src/datastructures/balancedbrackets/testcase03in.txt");
        File outFilePath = new File(currentDir + "/src/datastructures/balancedbrackets/testcase03out.txt");
        Scanner in = new Scanner(inFilePath);
        Scanner out = new Scanner(outFilePath);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String expectedResult = out.next();
            boolean result = isBalanced(s);
            if (result) {
                System.out.println("YES" + " : " + expectedResult);
            }
            else {
                System.out.println("NO" + " : " + expectedResult);
            }
        }
        in.close();
    }
}
