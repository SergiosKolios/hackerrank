package com.hackerrank.sorting.RunningTimeOfAlgorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int runningTime(int[] arr) {
        int size = arr.length;
        int moveCount = 0;
        for (int i = 1; i < size; i++) {
            int value = arr[i];
            int j = i-1;
            while (j >= 0 && value < arr[j]) {
                arr[j+1] = arr[j];
                j = j-1;
                moveCount ++;
            }
            arr[j + 1] = value;
        }
        return moveCount;
    }

    public static void main(String[] args) {
        int[] ar = {2, 1, 3, 1, 2};
//        int[] ar = {1, 1, 2, 2, 3, 3, 5, 5, 7, 7, 9, 9};
        runningTime(ar);
    }
}
