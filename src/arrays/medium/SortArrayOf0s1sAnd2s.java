package arrays.medium;

import java.util.Arrays;

public class SortArrayOf0s1sAnd2s {
    public static void sortArray(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        while (mid <= high) {
            if (array[mid] == 0) {
                swap(array, low, mid);
                low++;
                mid++;
            }
            else if (array[mid] == 1) {
                mid++;
            }
            else {
                swap(array, mid, high);
                high--;
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 2, 0, 1};
        System.out.println("Array before sorting:");
        System.out.println("After Sorting");
        sortArray(array);
        System.out.println(Arrays.toString(array));

    }
}
