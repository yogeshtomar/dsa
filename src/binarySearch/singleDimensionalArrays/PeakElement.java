package binarySearch.singleDimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakElement {
    public static int peakElement(List<Integer> array) {
        int n = array.size();
        if (n == 1) {
            return 0;
        }
        if (array.get(0) > array.get(1)) {
            return 0;
        }
        if (array.get(n-1) > array.get(n-2)) {
            return array.get(n-1);
        }

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array.get(mid-1) < array.get(mid) && array.get(mid) > array.get(mid+1)) {
                return mid;
            }

            if (array.get(mid) > array.get(mid - 1)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1));
        int ans = peakElement(arr);
        System.out.println("The peak " + arr.get(ans) + " is at index: " + ans);
    }
}
