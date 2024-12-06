package arrays.easy;

import java.util.Arrays;

public class LeftRotateTheArray {
    public static void leftRotateArray(int[] array) {
        int temp = array[0];
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i+1];
        }
        array[n-1] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println("Array before rotation: " + Arrays.toString(array));
        leftRotateArray(array);
        System.out.println("Array after rotation: " + Arrays.toString(array));
    }
}
