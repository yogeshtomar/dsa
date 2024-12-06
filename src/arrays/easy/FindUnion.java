package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindUnion {
    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                // Add arr1[i] to result and move i if not already added
                result.add(arr1[i]);
                i++;
            } else {
                // Add arr2[j] to result and move j if not already added
                result.add(arr2[j]);
                j++;
            }
        }

        // Add remaining elements of arr1, if any
        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }

        // Add remaining elements of arr2, if any
        while (j < arr2.length) {
            result.add(arr2[j]);
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {2, 3, 4, 4, 5, 11, 12};;

        List<Integer> union = findUnion(array1, array2);
        System.out.println("Union : " + union.toString());
    }
}
