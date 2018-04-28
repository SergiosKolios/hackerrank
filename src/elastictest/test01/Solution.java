package com.hackerrank.elastictest.test01;

public class Solution {

    static int[] merge(int[] a, int[] b) {
        int na = a.length;
        int nb = b.length;

        int[] result = new int[na + nb];

        int i = 0;
        int j = 0;
        int c = 0;
        while (i < na && j < nb) {
            if (a[i] < b[j]){
                result[c] = a[i];
                i++;
                c++;
            } else {
                result[c] = b[j];
                j++;
                c++;
            }
        }
        while (i < na) {
            result[c] = a[i];
            i++;
            c++;
        }
        while (j < nb) {
            result[c] = b[j];
            j++;
            c++;
        }
        return result;
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }
}
