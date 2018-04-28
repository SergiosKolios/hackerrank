package com.hackerrank.testchallenge.test02;

public class Solution {

    public static void main(String[] args) {


    }

    private static void printArray(int[] ar) {
        StringBuilder builder = new StringBuilder();
        for(int o : ar){
            builder.append(o).append(" ");
        }
        System.out.println(builder.toString());
    }
}
