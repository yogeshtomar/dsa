package binarySearch.singleDimensionalArrays;

public class HowManyTimesArrayIsRotated {
    public static int noOfRotations(int[] array) {
        int low = 0, high = array.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[low] <= array[high]) {
                if (array[low] < ans) {
                    index = low;
                    ans = array[low];
                }
                break;
            }
            if (array[low] <= array[mid]) {
                if (array[low] < ans) {
                    index = low;
                    ans = array[low];
                }
                low = mid + 1;
            }
            else {
                if (array[mid] < ans) {
                    index = mid;
                    ans = array[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int k = noOfRotations(arr);
        System.out.println("The array is rotated " + k + " no of times.");


    }
}
