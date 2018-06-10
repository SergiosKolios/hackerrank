package crackingthecodinginterview.arrayleftrotation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the rotLeft function below.
    private static int[] rotLeft(int[] a, int d) {

        for (int i = 0; i < d; i++) {
            int dummy = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j+1];
            }
            a[a.length -1] = dummy;
        }

        return a;
    }


    public static void main(String[] args) throws IOException {
        String currentDir = System.getProperty("user.dir");
        File inFilePath = new File(currentDir + "/src/crackingthecodinginterview/arrayleftrotation/InExample.txt");
        File outFilePath = new File(currentDir + "/src/crackingthecodinginterview/arrayleftrotation/Output.txt");
        Scanner in = new Scanner(inFilePath);
        Scanner out = new Scanner(outFilePath);

        int n = in.nextInt();
        int d = in.nextInt();

        int[] a = new int[n];

        in.nextLine();
        String[] aItems = in.nextLine().split(" ");
        out.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        System.out.println(Arrays.toString(result));
    }
}
