package dynamicProgramming.onLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintTheLongestIncreasingSubsequence {
    public static List<Integer> findLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        List<Integer> result = new ArrayList<>();
        lisUtil(0, -1, nums, dp);
        reconstructLIS(0, -1, nums, dp, result);
        return result;
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

    private static void reconstructLIS(int idx, int prevIdx, int[] nums, int[][] dp, List<Integer> result) {
        if (idx == nums.length) {
            return;
        }

        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            int include = 1 + (idx +1 < nums.length ? dp[idx+1][idx+1] : 0);
            int skip = idx+1 < nums.length ? dp[idx+1][prevIdx+1] : 0;
            if (include >= skip) {
                result.add(nums[idx]);
                reconstructLIS(idx+1, idx, nums, dp, result);
                return;
            }
        }
        reconstructLIS(idx+1, prevIdx, nums, dp, result);
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        List<Integer> lis = findLIS(nums);

        System.out.println("Longest Increasing Subsequence:");
        System.out.println(lis); // Output: [2, 3, 7, 101]
    }
}
