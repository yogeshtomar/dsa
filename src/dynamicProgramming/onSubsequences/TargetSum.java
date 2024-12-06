package dynamicProgramming.onSubsequences;

import java.util.Arrays;

/**
 * We are given an array ‘ARR’ of size ‘N’ and a number ‘Target’. Our task is to build an expression from the given
 * array where we can place a ‘+’ or ‘-’ sign in front of an integer. We want to place a sign in front of every
 * integer of the array and get our required target. We need to count the number of ways in which we can achieve
 * our required target.
 */

public class TargetSum {
    public static int targetSum(int target, int[] array) {
        int n = array.length;
        int totalSum = Arrays.stream(array).sum();

        if (totalSum - target < 0) {
            return 0;
        }

        if ((totalSum - target) % 2 == 1) {
            return 0;
        }

        int sum2 = (totalSum - target)/2;
        int[][]dp = new int[n][sum2+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return targetSumUtil(n-1, sum2, array, dp);
    }

    private static int targetSumUtil(int index, int target, int[] array, int[][] dp) {
        if (index == 0) {
            if (target == 0 && array[0] == 0) {
                return 2;
            }

            if (target == 0 || target == array[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int excluded = targetSumUtil(index-1, target, array, dp);
        int included = 0;
        if (array[index] <= target) {
            included = targetSumUtil(index-1, target - array[index], array, dp);
        }
        return dp[index][target] = (included + excluded);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1};
        int target = 3;

        System.out.println("The number of ways found is : " + targetSum(target, array));
        System.out.println("The number of ways found by tabulation : " + tabulation(array, target));
    }

    public static int tabulation(int[] array, int target) {
        int n = array.length;
        int totalSum = Arrays.stream(array).sum();
        // Check if target + totalSum is valid
        if ((target + totalSum) % 2 != 0 || target + totalSum < 0) return 0;

        int subsetSum = (target + totalSum) / 2;
        int[][] dp = new int[n+1][subsetSum + 1];

        dp[0][0] = 1;
        for (int j = 1; j <= subsetSum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                dp[i][j] = dp[i-1][j];

                if (array[i-1] <= j) {
                    dp[i][j] += dp[i-1][j - array[i-1]];
                }
            }
        }
        return dp[n-1][subsetSum];
    }
}
