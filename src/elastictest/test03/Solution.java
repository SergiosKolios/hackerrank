package com.hackerrank.elastictest.test03;

public class Solution {

    /*
     * Please complete the function below.
     */
    static boolean isBalanced(String text) {

        int open = 0;
        int closed = 0;
        for (int i = 0; i < text.length(); i++) {
            String str = "" + text.charAt(i);
            if (str.equals('(')) {
                open ++;
            }
            if (str.equals(')')) {
                closed ++;
            }
        }
        return (open - closed) == 0;
    }


    public static void main(String[] args) {
        boolean result = isBalanced("(this OR that) AND (that OR this )");
        System.out.println(result);
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }
}
