package binarySearch.singleDimensionalArrays;

public class SearchInSortedRotatedArray {
    public static int search(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[low] == array[mid] && array[mid] == array[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (array[low] <= array[mid]) {
                if (array[low] <= key && key <= array[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (array[mid] <= key && key <= array[high]) {
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
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        System.out.println("The index of " + k + " is : " + search(arr, k));
    }
}
