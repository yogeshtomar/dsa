package dynamicProgramming.onLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lisUtil(0, -1, nums, dp);
    }

    private static int lisUtil(int idx, int prevIdx, int[] nums, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][prevIdx+1] != -1) {
            return dp[idx][prevIdx+1];
        }

        int skip = lisUtil(idx+1, prevIdx, nums, dp);

        int include = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            include = 1 + lisUtil(idx+1, idx, nums, dp);
        }
        return dp[idx][prevIdx+1] = Math.max(skip, include);
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS : " + lengthOfLIS(nums));
    }
}
