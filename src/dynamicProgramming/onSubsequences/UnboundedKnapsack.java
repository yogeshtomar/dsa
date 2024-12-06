package dynamicProgramming.onSubsequences;

import java.util.Arrays;

/**
 * A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items of infinite supply.
 * Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include an item in its knapsack or exclude it
 * but can’t partially have it as a fraction. We need to find the maximum value of items that the thief can steal.
 * He can take a single item any number of times he wants and put it in his knapsack.
 */

public class UnboundedKnapsack {
    private static int maxAmountUtil(int idx, int capacity, int[] weights, int[] values, int[][] dp) {
        if (idx == 0) {
            return (capacity / weights[0]) * (values[0]);
        }

        if (dp[idx][capacity] != -1) {
            return dp[idx][capacity];
        }

        int notTaken = maxAmountUtil(idx-1, capacity, weights, values, dp);
        int taken = 0;
        if (weights[idx] <= capacity) {
            taken = values[idx] + maxAmountUtil(idx, capacity - weights[idx], weights, values, dp);
        }
        return dp[idx][capacity] = Math.max(taken, notTaken);
    }

    public static int maxAmount(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n][capacity+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxAmountUtil(n-1, capacity, weights, values, dp);
    }

    public static void main(String[] args) {
        int[] weights = {2, 4, 6};
        int[] values = {5, 11, 13};

        int W = 10;

        System.out.println("Max profit the thief can get: " + maxAmount(W, weights, values));
        System.out.println("Max profit the thief can earn using tabulation: " + tabulation(W, weights, values));
    }

    private static int tabulation(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n][capacity+1];

        for (int i = weights[0]; i <= capacity; i++) {
            dp[0][i] = (int) (i / weights[0]) * values[0];
        }

        for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= capacity; cap++) {
                int notTaken = dp[i-1][cap];
                int taken = Integer.MIN_VALUE;
                if (weights[i] <= cap) {
                    taken = dp[i][cap-weights[i]] + values[i];
                }
                dp[i][cap] = Math.max(notTaken, taken);
            }
        }
        return dp[n-1][capacity];
    }
}
