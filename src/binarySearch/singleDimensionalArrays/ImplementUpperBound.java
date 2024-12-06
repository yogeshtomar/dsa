package binarySearch.singleDimensionalArrays;

public class ImplementUpperBound {
    public static int upperBound(int[] array, int k) {
        int low = 0, high = array.length - 1;
        int ans = array.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > k) {
                ans = mid;
                high = mid - 1;
            }
             else {
                 low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, n);
        System.out.println("The upper bound is the index: " + ind);
    }
}
