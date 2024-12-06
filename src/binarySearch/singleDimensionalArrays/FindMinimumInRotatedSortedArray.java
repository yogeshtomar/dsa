package binarySearch.singleDimensionalArrays;

import java.util.Map;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] array) {
        int low = 0, high = array.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[low] <= array[high]) {
                ans = Math.min(ans, array[low]);
                break;
            }
            if (array[low] <= array[mid]) {
                ans = Math.min(ans, array[low]);
                low = mid + 1;
            }
            else {
                ans = Math.min(ans, array[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);
        System.out.println("The Minimum Element in the array is : " + ans);
    }
}
