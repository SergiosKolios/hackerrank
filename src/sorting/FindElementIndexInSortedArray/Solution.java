package com.hackerrank.sorting.FindElementIndexInSortedArray;

import java.util.Scanner;

public class Solution {

    private static int findIndexOfElementInArray(int value, int arraySize, int[] inputArray){
        int index = -1;
        boolean notFound = true;
        int currPos = arraySize/2;
        while(notFound) {
            int midValue = inputArray[currPos];
            if( value < midValue) {
                currPos = currPos/2;
            } else if (value > midValue) {
                currPos += (arraySize - currPos)/2;
            } else if (value == midValue) {
                index = currPos;
                notFound = false;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int z = 23;
        int[] intArray = {1, 4, 5, 7, 9, 12, 15, 19, 23, 25};
        int n = intArray.length;
        int result = 0;
        result = findIndexOfElementInArray(z, n, intArray);
        System.out.println(result);
    }
}
