package com.hackerrank.sorting.MatrixDiagonalAbsolutDiff;

import java.io.*;
import java.util.*;
import java.lang.Math;
public class Solution {

    private static long absDiagonalSum(int dimSize, int[][] matrix){
        long result;
        long sumNormal = 0;
        long sumReverse = 0;
        for (int i = 0; i < dimSize; i++) {
            sumNormal  += matrix[i][i];
            sumReverse += matrix[i][dimSize-1-i];
        }

//        System.out.println("Normal: " + sumNormal + " . Reverse: " + sumReverse);
        result = Math.abs(sumNormal - sumReverse);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matrix[i][j]=in.nextInt();
            }
        }
        long result = absDiagonalSum(n, matrix);
        System.out.println(result);
    }
}