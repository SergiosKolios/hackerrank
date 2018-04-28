package com.hackerrank.sorting.TheFullCountingSort;

import java.util.Scanner;

public class Solution {

    private static String[] sortCorresponsingStringArray(int arraySize,
                                                         int maxIndex,
                                                         int[] indexArray,
                                                         String[] wordArray){
        String[] result = new String[arraySize];
        int k = 0;
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (indexArray[j] == i) {
                    result[k] = wordArray[j];
                    k ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 20;
        int indexMax = 100;
        int[] index = {0, 6, 0, 6, 4, 0, 6, 0, 6, 0, 4, 3, 0, 1, 5, 1, 2, 4, 2, 4};
        String[] words = {"ab", "cd", "ef", "gh", "ij", "ab", "cd", "ef", "gh", "ij", "that", "be", "to", "be", "question", "or", "not", "is", "to", "the"};
        for (int i = 0; i < n/2; i++) {
            words[i] = "-";
        }
        String[] result = sortCorresponsingStringArray(n, indexMax, index, words);
        prStrArray(result);
        in.close();
    }

    private static void prStrArray(String[] ar) {
        StringBuilder builder = new StringBuilder();
        for(String string : ar){
            builder.append(string).append(" ");
        }
        System.out.println(builder.toString());
    }
}
