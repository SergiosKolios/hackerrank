package com.hackerrank.sorting.InsertionSortPart1;

import java.util.Scanner;

public class Solution {

    public static void insertIntoSorted(int[] array) {
        int s = array.length;
        int v = array[s-1];
        for(int i = s-2; i  >=0; i--){
            if(v >= array[i]){//Found where it goes
                array[i+1] = v;
                printArray(array);
                break;
            }
            array[i+1] = array[i];//Shift to the right
            printArray(array);
        }
        if(v < array[0]){
            array[0] = v;
            printArray(array);
        }

    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 3};
        int size = array.length;
        insertIntoSorted(array);
    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
