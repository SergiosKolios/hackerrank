package com.hackerrank.sorting.InsertionSortAdvancedAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static long insertionSort(int size, int[] arr) {
        long start = System.currentTimeMillis();
        long result = 0;

        int max = maxElement(size, arr);
        int[] binIndexTree = new int[max+1];

        for (int i=size-1; i>=0; i--){
            int value = arr[i];
            result += getSum(value-1, binIndexTree);
            // Add current element to BIT
            updateBIT(binIndexTree, max, arr[i], 1);
        }
        System.out.println("Number of elements: " + size + ". Running Time: "
                + (System.currentTimeMillis() - start) + " ms "
                + ".Result: " + result);
//        printArray(arr);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\sorting\\InsertionSortAdvancedAnalysis\\sample.txt");
        Scanner in = new Scanner(inFile);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            long result = insertionSort(n, array);
            System.out.println(result);
        }
    }

    private static void updateBIT(int bTree[], int n, int index, int val) {
        // Traverse all ancestors and add 'val'
        while (index <= n) {
            bTree[index] += val;
            index = index + (index & (-index));
        }
    }

    private static long getSum(int index, int bTree[]) {
        int sum = 0;
        // Get the sum of values of all smaller elements
        while (index > 0){
            sum += bTree[index];
            index = index - (index & (-index));
        }
        return sum;
    }

    private static int maxElement(int n, int[] arr) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }
}