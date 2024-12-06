package binarySearch.bsOnAnswers;

public class MinDaysToMakeBouquets {
    public static int minDays(int[] bloomTime, int targetBouquets, int adjacentFlowersReq) {
        if (bloomTime.length < targetBouquets * adjacentFlowersReq) {
            return -1;
        }

        int low = 1, high = Integer.MAX_VALUE;

        while (low < high) {
            int mid = low + (high - low)/ 2;
            if (canMakeBouquets(bloomTime, targetBouquets, adjacentFlowersReq, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canMakeBouquets(int[] bloomTime, int targetBouquets, int adjFlowers, int maxDays) {
        int bouquets = 0;
        int flowersPicked = 0;

        for (int bloom : bloomTime) {
            if (bloom <= maxDays) {
                flowersPicked++;

                if (flowersPicked == adjFlowers) {
                    bouquets++;
                    flowersPicked = 0;
                }
            }
            else {
                flowersPicked = 0;
            }

            if (bouquets >= targetBouquets) {
                return true;
            }
        }
        return bouquets >= targetBouquets;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}
