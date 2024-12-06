package arrays.easy;

import java.util.Arrays;

public class RotateArrayByKPlaces {
    private static void reverse(int[] array, int start, int end) {
        while (start <= end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateLeft(int[] array, int n, int k) {
        reverse(array, 0, k-1);
        reverse(array, k, n - 1);
        reverse(array, 0, n-1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int n = array.length;
        int k = 2;
        System.out.println("Array before rotation: " + Arrays.toString(array));
        rotateLeft(array, n, k);
        System.out.println("Array after rotation: " + Arrays.toString(array));
    }
}
