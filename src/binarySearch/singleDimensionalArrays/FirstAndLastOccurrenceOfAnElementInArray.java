package binarySearch.singleDimensionalArrays;

public class FirstAndLastOccurrenceOfAnElementInArray {
    public static int firstOccurrence(int[] array, int key) {
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

    public static int lastOccurrences(int[] array, int key) {
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

    public static void main(String[] args) {
        int[] array = {3,4,13,13,13,20,40};
        int key = 13;
        System.out.println("The first occurrence of " + key + " is : " + firstOccurrence(array, key) );
        System.out.println("The last occurrence of " + key + " is : " + lastOccurrences(array, key) );
    }
}
