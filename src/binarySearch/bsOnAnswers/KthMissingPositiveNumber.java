package binarySearch.bsOnAnswers;

public class KthMissingPositiveNumber {
    public static int missingK(int[] array, int k) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int missing = array[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 9, 10};
        int k = 4;
        System.out.println("The missing number is: " + missingK(array, k));
    }
}
