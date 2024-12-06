package dynamicProgramming.onStocks;

import java.util.Arrays;

public class BuyAndSellStocks3 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return maxProfitUtil(0, 0, 2,prices, dp);
    }

    private static int maxProfitUtil(int idx, int holding, int transactionsRemaining, int[] prices, int[][][] dp) {
        if (idx == prices.length || transactionsRemaining == 0) {
            return 0;
        }
        if (dp[idx][holding][transactionsRemaining] != -1) {
            return dp[idx][holding][transactionsRemaining];
        }
        int skip = maxProfitUtil(idx+1, holding, transactionsRemaining,prices, dp);
        // if holding a stock we can sell it
        if (holding == 1) {
            int sell = prices[idx] + maxProfitUtil(idx+1, 0, transactionsRemaining-1,prices, dp);
            dp[idx][holding][transactionsRemaining] = Math.max(skip, sell);
        }
        else {
            // if not holding a stock we can buy it
            int buy = -prices[idx] + maxProfitUtil(idx+1, 1, transactionsRemaining, prices, dp);
            dp[idx][holding][transactionsRemaining] = Math.max(skip, buy);
        }
        return dp[idx][holding][transactionsRemaining];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.println("The maximum profit that can be generated is: " + maxProfit(prices));
    }
}
