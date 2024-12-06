package binarySearch.singleDimensionalArrays;

public class CountOccurencesInSortedArray {
    public static int firstOccurence(int[] array, int key) {
        int low = 0, high = array.length-1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (array[mid] == key) {
                first = mid;
                high = mid - 1;
            }
            else if (array[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastOccurences(int[] array, int key) {
        int low = 0, high = array.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (array[mid] == key) {
                last = mid;
                low = mid + 1;
            }
            else if (array[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int count(int[] array, int key) {
        int first = firstOccurence(array, key);
        int last = lastOccurences(array, key);
        if (first == -1) return 0;
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 8, 8, 11, 13};
        int key = 8;
        System.out.println("The number of occurrences is: " + count(array, key));
    }
}
