package com.hackerrank.sorting.MergeSort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class MergeSort {

    private void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int left, int middle, int right) {
        int ln = middle - left + 1;
        int rn = right - middle;

        int leftArray[] = new int [ln];
        int rightArray[] = new int [rn];
        // Copy of Arrays
        for (int i=0; i<ln; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j=0; j<rn; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = left;
        while (i < ln && j < rn) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < ln) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rn) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /* A utility function to print array of size n */
    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }

    // Driver method
    public static void main(String args[]) throws IOException{
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\sorting\\MergeSort\\Input\\input00.txt");
        Scanner in = new Scanner(inFile);
        int n = in.nextInt();
        // Init Array and add data
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        MergeSort ob = new MergeSort();
        ob.sort(array, 0, array.length-1);

        System.out.println("\nSorted array");
        printArray(array);
    }

}