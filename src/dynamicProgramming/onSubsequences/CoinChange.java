package dynamicProgramming.onSubsequences;

import java.util.Arrays;

/**
 * We are given an array Arr with N distinct coins and a target. We have an infinite supply of each coin denomination.
 * We need to find the number of ways we sum up the coin values to give us the target.
 */

public class CoinChange {
    private static int countWaysUtil(int index, int target, int[] coins, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int exclude = countWaysUtil(index-1, target, coins, dp);
        int include = 0;
        if (coins[index] <= target) {
            include = countWaysUtil(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = include + exclude;
    }

    public static int countWays(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countWaysUtil(n-1, target, coins, dp);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;

        System.out.println("The number of ways to make change: " + countWays(coins, target));
        System.out.println("The number of ways to make change using tabulation: " + tabulation(target, coins));
    }

    private static int tabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= amount; sum++) {
                int excluded = dp[idx-1][sum];
                int included = 0;
                if (sum >= coins[idx]) {
                    included = dp[idx][sum-coins[idx]];
                }
                dp[idx][sum] = excluded + included;
            }
        }
        return dp[n-1][amount];
    }
}
