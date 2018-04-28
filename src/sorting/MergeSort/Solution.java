package com.hackerrank.sorting.MergeSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle+1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int ln = middle - left + 1; // product of int division (e.g. (0+3)/2 = 1) thus adding one
        int rn = right - middle;    // last index subtract middle (e.g. 3-1 = 2) inclusive

        int leftArray[] = new int[ln];
        int rightArray[] = new int[rn];

        for (int i=0; i < ln; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j=0; j < rn; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int l = 0;      // index of left sub-segment
        int r = 0;      // index of right sub-segment
        int k = left;   // index of merged array

        // Compare left-most and rightmost elements and add substitute in merged array
        while (l < ln && r < rn) {
            if (leftArray[l] <= rightArray[r]) {
                array[k] = leftArray[l];
                l++;
            } else {
                array[k] = rightArray[r];
                r++;
            }
            k++;
        }
        // Add remaining elements of non-empty sub-segment to merged array
        while (l < ln) {
            array[k] = leftArray[l];
            l++;
            k++;
        }
        while (r < rn) {
            array[k] = rightArray[r];
            r++;
            k++;
        }
    }

    public static void main(String[] args) throws IOException{
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\sorting\\MergeSort\\Input\\input01.txt");
        Scanner in = new Scanner(inFile);
        int n = in.nextInt();
        // Init Array and add data
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println("Initial Array");
        printArray(array);
        Solution ms = new Solution();
        ms.mergeSort(array, 0, array.length-1);
        System.out.println("\nSorted Array");
        printArray(array);
    }

    private static void printArray(int ar[]) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }
}
