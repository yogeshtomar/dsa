package binarySearch.singleDimensionalArrays;

public class FloorAndCeil {
    public static int floor(int[] array, int x) {
        int low = 0, high = array.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (array[mid] <= x) {
                ans = array[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int[] array, int x) {
        int low = 0, high = array.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] >= x) {
                ans = array[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 4, 7, 8, 10};
        int x = 5;

        System.out.println("The floor is: " + floor(array, x));
        System.out.println("The ceil is: " + ceil(array, x));
    }
}
