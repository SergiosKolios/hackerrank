package crackingthecodinginterview.balancedbrackers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static Map<Character, Character> matchingCharacterMap = new HashMap<>();

    static {
        matchingCharacterMap.put('{', '}');
        matchingCharacterMap.put('[', ']');
        matchingCharacterMap.put('(', ')');
    }


    private static boolean isBalanced(String expression) {
        // Quick exit if the string is null or empty
        if (expression == null || expression.isEmpty()) {
            return true;
        }

        Stack<Character> characterStack = new Stack<>();

        for (Character nextChar : expression.toCharArray()) {
            if (matchingCharacterMap.containsKey(nextChar)){
                characterStack.push(nextChar);
            }
            if (matchingCharacterMap.values().contains(nextChar)) {
                // Check if stack is already empty
                if(characterStack.isEmpty()){
                    return false;
                }
                Character currentChar = characterStack.pop();
                if (!matches(currentChar, nextChar)){
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    private static boolean matches(char a, char b) {
        if (matchingCharacterMap.get(a).equals(b)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        String currentDir = System.getProperty("user.dir");
        File inFilePath = new File(currentDir + "/src/crackingthecodinginterview/balancedbrackers/TestCase4In.txt");
        File outFilePath = new File(currentDir + "/src/crackingthecodinginterview/balancedbrackers/TestCase4Out.txt");
        Scanner in = new Scanner(inFilePath);
        Scanner out = new Scanner(outFilePath);

        int t = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String result;
            String stringExpression = in.nextLine();
            String expectedResult = out.nextLine();
            boolean evaluate = isBalanced(stringExpression);
            if (evaluate) {
                result = "YES";
            }
            else {
                result = "NO";
            }

            if (!expectedResult.equals(result)) {
                System.out.println("Expected Result: " + expectedResult + " Algorithm Output: " + result + " Expression: " + stringExpression);
            }

        }

        in.close();


    }
}
