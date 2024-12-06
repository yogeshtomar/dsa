package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class SubsetSumEqualToTarget {
    public static boolean subsetSumToK(int[] array, int sum) {
        int n = array.length;
        int[][] dp = new int[n][sum+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return subsetSumUtil(n-1, sum, array, dp);
    }

    private static boolean subsetSumUtil(int index, int target, int[] array, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return array[0] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false: true;
        }

        boolean notTaken = subsetSumUtil(index-1, target, array, dp);
        boolean taken = false;
        if (array[index] <= target) {
            taken = subsetSumUtil(index-1, target-array[index], array, dp);
        }
        dp[index][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        if (subsetSumToK(arr, k))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        System.out.println("SubsetSum via tabulation : " + tabulation(arr, k));

    }

    public static boolean tabulation(int[] array, int sum) {
        int n  = array.length;
        boolean[][] dp = new boolean[n][sum+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (array[0] <= sum) {
            dp[0][array[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTaken = dp[index-1][target];

                boolean taken = false;
                if (array[index] <= target) {
                    taken = dp[index-1][target-array[index]];
                }
                dp[index][target] = notTaken | taken;
            }
        }
        return dp[n-1][sum];
    }
}
