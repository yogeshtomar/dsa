package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static int countWays(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countWaysUtil(n-1, k, nums, dp);
    }

    private static int countWaysUtil(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) {
            return 1;
        }

        if (index == 0) {
            return nums[0] == target ? 1 : 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTaken = countWaysUtil(index - 1,  target, nums, dp);
        int taken = 0;
        if (target >= nums[index]) {
            taken = countWaysUtil(index-1, target - nums[index], nums, dp);
        }
        return dp[index][target] = notTaken + taken;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int k = 3;
        System.out.println("The number of subsets found with sum " + k + " are : " + countWays(array, k));
        System.out.println("The number of subsets found with sum " + k + " are : " + tabulation(array, k));
    }

    public static int tabulation(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                int exclude = dp[i-1][target];

                int included = 0;
                if (nums[i] <= target) {
                    included = dp[i-1][target-nums[i]];
                }
                dp[i][target] = included + exclude;
            }
        }
        return dp[n-1][k];
    }
}
