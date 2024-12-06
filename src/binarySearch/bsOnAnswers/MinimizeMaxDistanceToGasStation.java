package binarySearch.bsOnAnswers;

public class MinimizeMaxDistanceToGasStation {
    public static int numberOfGasStationsRequired(double distance, int[] array) {
        int n = array.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int numInBetween = (int) ((array[i] - array[i-1])/distance);
            if (array[i] - array[i-1] == (distance * numInBetween)) {
                numInBetween--;
            }
            count += numInBetween;
        }
        return count;
    }

    private static double minimiseMaxDistance(int[] array, int k) {
        int n = array.length;
        double low = 0, high = 0;

        for (int i = 0; i < n-1; i++) {
            high = Math.max(high, (double) (array[i+1] - array[i]));
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(mid, array);
            if (count > k) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
