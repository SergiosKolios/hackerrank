package com.hackerrank.sorting.InsertionSortPart2;

import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            System.out.println(array[i+1]);
            if(array[i+1] < array[i]) {
                int toMove = array[i+1];
                for (int j = i+1; j > 0; j--){
                    if(array[j-1] > toMove) {
                        array[j] = array[j - 1];
                        array[j - 1] = toMove;
                    }
                }
            }
            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] ar = {1, 4, 3, 5, 6, 2};
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}