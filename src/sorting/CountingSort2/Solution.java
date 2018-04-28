package com.hackerrank.sorting.CountingSort2;

public class Solution {

    private static int[] countingSort(int[] array) {
        int maxValue = 100;
        int arraySize = array.length;
        int[] result = new int[arraySize];
        int k = 0;
        for (int i = 0; i < maxValue; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (array[j] == i) {
                    result[k] = i;
                    k++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33};
        int[] result = countingSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
}
