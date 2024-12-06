package binarySearch.bsOnAnswers;

public class KokoEatingBananas {
    private static int findMaxHours(int[] bananas) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bananas.length; i++) {
            max = Math.max(max, bananas[i]);
        }
        return max;
    }

    private static int calculateTotalHours(int[] bananas, int hourlyRate) {
        int totalHours = 0;
        int n = bananas.length;
        for (int i = 0; i < n; i++) {
            totalHours += (int) Math.ceil( (double) (bananas[i]) / (double) (hourlyRate));
        }
        return totalHours;
    }
    public static int minimumRateToEatBananas(int[] bananas, int hours) {
        int low = 1, high = findMaxHours(bananas);

        while (low <= high) {
            int mid = low + (high - low)/2;
            int totalHours = calculateTotalHours(bananas, mid);
            if (totalHours <= hours) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bananaPiles = {7, 15, 6, 3};
        int hours = 8;
        int ans = minimumRateToEatBananas(bananaPiles, hours);
        System.out.println("Koko should eat at least " + ans + " bananas/hour.");
    }
}
