package slidingWindowAndTwoPointers;

public class MaxPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int left = 0, right = cardPoints.length;
        int n = cardPoints.length;

        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }

        int fixedWindowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < fixedWindowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        for (int i = fixedWindowSize; i < n; i++) {
            windowSum += (cardPoints[i] - cardPoints[i - fixedWindowSize]);
            minWindowSum = Math.min(minWindowSum, windowSum);
        }
        return sum - minWindowSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        System.out.println("Max score : " + maxScore(cardPoints, k));
    }
}
