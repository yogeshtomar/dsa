package dynamicProgramming.onStocks;

import java.util.Arrays;

public class BuySellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxProfitUtil(0, 0, prices, fee, dp);
    }
    private static int maxProfitUtil(int idx, int holding, int[] prices, int fee, int[][] dp) {
        if (idx >= prices.length) {
            return 0;
        }
        if (dp[idx][holding] != -1) {
            return dp[idx][holding];
        }

        int skip = maxProfitUtil(idx+1, holding, prices, fee, dp);

        if (holding == 1) {
            int sell = prices[idx] - fee + maxProfitUtil(idx+1, 0, prices, fee, dp);
            dp[idx][holding] = Math.max(skip, sell);
        }
        else {
            int buy = -prices[idx] + maxProfitUtil(idx +1, 1, prices, fee, dp);
            dp[idx][holding] = Math.max(skip, buy);
        }
        return dp[idx][holding];
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println("Maximum Profit for prices1: " + maxProfit(prices1, fee1)); // Output: 8

        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println("Maximum Profit for prices2: " + maxProfit(prices2, fee2)); // Output: 6
    }
}
