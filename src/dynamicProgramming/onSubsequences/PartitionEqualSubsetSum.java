package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] array) {
        int n = array.length;
        int totalSum = 0;
        for (int item : array) {
            totalSum += item;
        }

        if (totalSum % 2 == 1) {
            return false;
        }
        else {
            int target = totalSum / 2;
            int[][] dp = new int[n][target+1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return subsetSumUtil(n-1, target, array, dp) ;
        }
    }

    private static boolean subsetSumUtil(int index, int target, int[] array, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == array[0];
        }
        if (dp[index][target] != -1) {
            return dp[index][target] != 0;
        }

        boolean notTaken = subsetSumUtil(index-1, target, array, dp);
        boolean taken = false;
        if (array[index] <= target) {
            taken = subsetSumUtil(index-1, target-array[index], array, dp);
        }
        dp[index][target] = taken || notTaken ? 1 : 0;
        return notTaken || taken;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 3, 3, 4, 5};
        if (canPartition(array)) {
            System.out.println("The Array can be partitioned into two equal subsets");
        }
        else {
            System.out.println("The array can not be partitioned into two equal subsets ");
        }
    }
}
