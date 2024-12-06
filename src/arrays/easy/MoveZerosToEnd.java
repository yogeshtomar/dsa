package arrays.easy;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void moveZeros(int[] arrays, int size) {
        int j = -1;
        for (int i = 0; i < size; i++) {
            if (arrays[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        int i = j+1;
        while (i < size) {
            if (arrays[i] != 0) {
                swap(arrays, i, j);
                j++;
            }
            i++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = 10;
        moveZeros(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
