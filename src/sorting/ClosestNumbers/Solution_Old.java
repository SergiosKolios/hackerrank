package com.hackerrank.sorting.ClosestNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Old {

    private static int[] closestNumbers(int size, int[] array) {
        List<Integer> result = new ArrayList<>();
        int closestDiff = Integer.MAX_VALUE;
        result.add(0);
        result.add(0);
        for(int i = 0; i < size-1; i++) {
            int j = i+1;
            while (j < size) {
                if (Math.abs(array[j] - array[i]) < Math.abs(closestDiff)) {
                    closestDiff = Math.abs(array[i] - array[j]);
                    result.set(0, array[i]);
                    result.set(1, array[j]);
                } else if (Math.abs(array[j] - array[i]) == Math.abs(closestDiff)) {
                    result.add(array[i]);
                    result.add(array[j]);
                }
                j++;
            }
        }
        return result.stream().mapToInt(v -> v).sorted().toArray();
    }

    public static void main(String[] args) {
//        int[] array = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};
        int[] array = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470};
//        int[] array = {5, 4, 3, 2};
        int n = array.length;
        int[] result = closestNumbers(n, array);
        printArray(result);
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int integer : ar){
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString());
    }

}
