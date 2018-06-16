package crackingthecodinginterview.quicksort;

import java.util.Arrays;

public class Solution {

    private static int[] quicksort(int[] array) {
        return quicksort(array, 0, array.length-1);
    }

    private static int[] quicksort(int[] array, int left, int right){
        if (left >= right) {
            return array;
        }

        int pivot = array[ (left + right) /2 ];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index -1);
        quicksort(array, index, right);

        return array;
    }

    private static int partition(int[] array, int left, int right, int pivot) {
          while (left <=right) {
              while (array[left] < pivot){
                  left++;
              }

              while (array[right] > pivot) {
                  right--;
              }

              if (left <= right) {
                  array = swap(array, left, right);
                  left++;
                  right--;
              }
          }
          return left;

    }

    private static int[] swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;

//        ""
        return array;
    }


    public static void main(String[] args) {
        int[] array = {9, 2, 6, 4, 3, 5, 1};

        System.out.println(Arrays.toString(array));

        array = quicksort(array);

        System.out.println(Arrays.toString(array));

    }

}
