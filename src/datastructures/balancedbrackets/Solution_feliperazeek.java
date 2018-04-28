package com.hackerrank.datastructures.balancedbrackets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution_feliperazeek {

    private static List<Character> openChars = new ArrayList<>(Arrays.asList('{', '(', '['));
    private static List<Character> closeChars = new ArrayList<>(Arrays.asList('}', ')', ']'));

    private static boolean isBalanced(String s) {
        // Quick exit if the string is null or empty
        if (s == null || s.isEmpty()) {
            return true;
        }
        // Stack of previous brackets
        Stack<Character> stack = new Stack<Character>();

        // Iterate through the String characters
        for (char c : s.toCharArray()) {
            // case of an opening character, add to stack last element
            if (openChars.contains(c)) {
                stack.push(c);
            }

            // case of a closing character
            if (closeChars.contains(c)) {
                // if the stack is empty and characters are still left
                if (stack.empty()) {
                    return false;
                }
                // Get the last character of the stack
                char openChar = stack.pop();
                if (!matches(openChar, c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private static boolean matches(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\datastructures\\balancedbrackets\\testcase03in.txt");
        File outFile = new File(currentDir + "\\src\\com\\hackerrank\\datastructures\\balancedbrackets\\testcase03out.txt");
        Scanner in = new Scanner(inFile);
        Scanner out = new Scanner(outFile);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String expectedResult = out.next();
            boolean result = isBalanced(s);
            if (result) {
                System.out.println("YES" + ":" + expectedResult);
            } else {
                System.out.println("NO" + ":" + expectedResult);
            }
        }
        in.close();
    }

}