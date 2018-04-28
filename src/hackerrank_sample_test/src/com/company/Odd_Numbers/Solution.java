package com.company.Odd_Numbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static int[] oddNumbers(int l, int r) {
        int diff = r - l;
        int size = 0;
        int startingNumber = 0;
        if(l%2 == 0) {
            startingNumber = l+1;
        } else {
            startingNumber = l;
        }
        if (diff%2 == 0) {
            size = diff/2;
        } else {
            size = diff/2 + 1;
        }
        int[] result = new int[size];

        int i = 0;
        while (i >= l && i <=r) {
            result[i] = startingNumber;
            i++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _l;
        _l = Integer.parseInt(in.nextLine().trim());

        int _r;
        _r = Integer.parseInt(in.nextLine().trim());

        res = oddNumbers(_l, _r);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

}
