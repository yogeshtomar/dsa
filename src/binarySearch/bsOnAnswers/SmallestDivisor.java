package binarySearch.bsOnAnswers;

public class SmallestDivisor {
    private static int sumByD(int[] array, int div) {
        int n = array.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil( (double) array[i] / (double) (div));
        }
        return sum;
    }
    public static int smallestDivisor(int[] array, int limit) {
        int n = array.length;
        if (n > limit) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, array[i]);
        }
        int low = 1, high = max;

        while (low <= high) {
            int mid = (low + (high - low)/2);
            if (sumByD(array, mid) <= limit) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int limit = 8;

        int ans = smallestDivisor(array, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}
