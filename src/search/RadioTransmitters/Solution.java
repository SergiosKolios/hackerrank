package com.hackerrank.search.RadioTransmitters;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int hackerlandRadioTransmitters(int[] houses, int k, int n) {
        printArray(houses);
        int transmitterCount = 0;
        int i = 0;
        while( i < n) {
            int transmitter = houses[i];
            int house = houses[i];
            transmitterCount++;
            // while there is a house in range increment i
            while (i < n && (houses[i] - house) <= k) {
                i++;
            }
            // move transmitter to the last house in range
            transmitter = houses[i - 1];
            // checking which houses are further covered
            // by the already placed transmitter
            while (i < n && houses[i] <= transmitter + k) {
                i++;
            }
        }
        return transmitterCount;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        int[] x = {7, 2, 4, 6, 5, 9, 12, 11};
        Arrays.sort(x);
        int result = hackerlandRadioTransmitters(x, k, n);
        System.out.println(result);
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int integer : ar){
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString());
    }
}
