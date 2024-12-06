package binarySearch.bsOnAnswers;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        int low = 1, high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid =  low + (high - low) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int[] stalls, int distance, int cows) {
        int n = stalls.length;
        int cowCount = 1;
        int last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= distance) {
                cowCount++;
                last = stalls[i];
            }
            if (cowCount >= cows) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}
