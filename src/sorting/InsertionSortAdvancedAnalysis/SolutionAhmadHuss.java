package com.hackerrank.sorting.InsertionSortAdvancedAnalysis;

import java.io.*;
import java.util.*;

public class SolutionAhmadHuss {

    // Returns sum of arr[0..index]. This function assumes
    // that the array is preprocessed and partial sums of
    // array elements are stored in BITree[].
    static int getSum(int BITree[], int index) {
        int sum = 0; // Initialize result
        // Traverse ancestors of BITree[index]
        while (index > 0){
            // Add current element of BITree to sum
            sum = sum + BITree[index];
            // Move index to parent node in getSum View
            index = index - (index & (-index));
        }
        return sum;
    }

    // Updates a node in Binary Index Tree (BITree) at given index
    // in BITree.  The given value 'val' is added to BITree[i] and
    // all of its ancestors in tree.
    static void updateBIT(int BITree[], int n, int index, int val) {
        // Traverse all ancestors and add 'val'
        while (index <= n){
            // Add 'val' to current node of BI Tree
            BITree[index] = BITree[index] + val;
            // Update index to that of parent in update View
            index = index + (index & (-index));
        }
    }

    // Returns inversion count arr[0..n-1]
    static long insertionSort(int arr[], int n){
        long invCount = 0; // Initialize result
        // Find maximum element in arr[]
        int maxElement = maxElement(n, arr);

        // Create a BIT with size equal to maxElement+1 (Extra
        // one is used so that elements can be directly be
        // used as index)
        int BIT[] = new int [maxElement+1];

        // Traverse all elements from right.
        for (int i=n-1; i>=0; i--){
            // Get count of elements smaller than arr[i]
            invCount = invCount + getSum(BIT, arr[i]-1);
            // Add current element to BIT
            updateBIT(BIT, maxElement, arr[i], 1);
        }
        return invCount;
    }

    // Driver program
    public static void main(String[]args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\sorting\\InsertionSortAdvancedAnalysis\\TestCase9In.txt");
        Scanner in = new Scanner(inFile);
        //Total times element want to sorted
            int t = in.nextInt();
            long inversion[] = new long[t];
            int length = 0;
            for(int i=1;i<=t;i++){
                //how many elements want to enter
                int n = in.nextInt();
                int data[] = new int[n];
                for(int j=0;j<n;j++){
                    data[j] = in.nextInt();
                }   //inner loop
                inversion[i-1] = insertionSort(data,n);
            }   //outer loop
            for(long k : inversion)
                System.out.println(k);
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
}