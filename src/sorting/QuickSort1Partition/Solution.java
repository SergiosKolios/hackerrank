package sorting.QuickSort1Partition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static int[] quickSort(int[] array) {
        int[] result = new int[array.length];
        int p = array[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > p) {
                right.add(array[i]);
            }
            if (array[i] < p) {
                left.add(array[i]);
            }
            if (array[i] == p) {
                equal.add(array[i]);
            }
        }
        left.addAll(equal);
        left.addAll(right);
        return left.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 3, 7, 2};
        int[] result = quickSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
    }
}
