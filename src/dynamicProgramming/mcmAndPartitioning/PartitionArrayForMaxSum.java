package dynamicProgramming.mcmAndPartitioning;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        return maxSumAfterPartitioningUtil(0, nums, k, dp);
    }

    private static int maxSumAfterPartitioningUtil(int idx, int[] nums, int k, int[] dp) {
        int n = nums.length;
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int maxSum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int j = idx; j < Math.min(idx+ k, n); j++) {
            maxElement = Math.max(maxElement, nums[j]);
            int currentSum = maxElement * (j - idx + 1) + maxSumAfterPartitioningUtil(j+1, nums, k, dp);
            maxSum = Math.max(maxSum, currentSum);
        }

        return dp[idx] = maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 15, 7, 9, 2, 5, 10};
        int k1 = 3;

        int[] arr2 = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k2 = 4;

        System.out.println("Maximum sum after partitioning arr1: " + maxSumAfterPartitioning(arr1, k1));
        System.out.println("Maximum sum after partitioning arr2: " + maxSumAfterPartitioning(arr2, k2));
    }

}
