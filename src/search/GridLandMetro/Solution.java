package com.hackerrank.search.GridLandMetro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static int gridlandMetro(int n, int m, int k, int[][] track) {

        int occupiedCells = 0;
        int[][] grid = new int[n][m];

        for (int i = 0; i < track.length; i++) {
            int row = track[i][0] - 1;
            int c1  = track[i][1] - 1;
            int c2  = track[i][2] - 1;

            for(int j = c1; j <= c2; j++) {
                grid[row][j] = 1;
            }
        }
        for(int g = 0; g < n; g++) {
            printArray(grid[g]);
        }

        occupiedCells = twoDArraySum(grid);

        return n * m - occupiedCells;
    }

    public static void main(String[] args) throws FileNotFoundException{
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\search\\GridLandMetro\\testcase5.txt");
        Scanner in = new Scanner(inFile);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        int result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();

        System.out.println(result);
    }

    private static int twoDArraySum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int integer : ar){
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString());
    }

}
