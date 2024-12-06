package arrays.hard;

import javax.swing.*;
import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void merge(long[] arr1, long[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int gap = (n + m + 1)/2;

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < n) {
                if (arr1[i] > arr1[j]) {
                    swap(arr1, i, j);
                }
                i++;
                j++;
            }

            j = (gap > n) ? gap - n : 0;
            while (i < n && j < m) {
                if (arr1[i] > arr2[j]) {
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
                j++;
            }

            if (j < m) {
                i = 0;
                while (j < m) {
                    if (arr2[i] > arr2[j]) {
                        swap(arr2, i, j);
                    }
                    i++;
                    j++;
                }
            }
            if (gap == 1) {
                break;
            }
            gap = (gap + 1)/2;
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        System.out.println(Arrays.toString(arr1));
        merge(arr1, arr2);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
