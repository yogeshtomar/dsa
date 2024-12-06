package binarySearch.singleDimensionalArrays;

import arrays.easy.LinearSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInRotatedSortedArray {
    public static int search(List<Integer> list, int key) {
        int low = 0 , high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == key) {
                return mid;
            }
            if (list.get(low) <= list.get(mid)) {
                if (list.get(low) <= key && key <= list.get(mid)) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (list.get(mid) <= key && key <= list.get(high)) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int k = 1;
        int ans = search(arr, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}
