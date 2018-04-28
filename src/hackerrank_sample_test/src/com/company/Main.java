package com.company;

import java.util.Scanner;

public class Main {
    /*
     * Complete the function below.
     */

    static String findNumber(int[] arr, int k) {
        int size = arr.length;

        if (size == 0) {
            return "NO";
        }

        for(int i = 0; i < size; i++) {
            if (arr[i] == k) {
                return "YES";
            }
        }
        return "NO";
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int currValue = in.nextInt();
        }
        int search = in.nextInt();

        String response = findNumber(array, search);
        System.out.println(response);
    }
}
