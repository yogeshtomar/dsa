package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    private static int mod = (int) (Math.pow(10, 9) + 7);
    public static int countPartitions(int d, int[] array) {
        int n = array.length;
        int totalSum = Arrays.stream(array).sum();

        if (totalSum - d < 0) {
            return 0;
        }
        if ((totalSum -d)%2 == 1) {
            return 0;
        }

        int s2 = (totalSum-d)/2;
        int[][] dp = new int[n][s2+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countPartitionsUtil(n-1, s2, array, dp);
    }

    private static int countPartitionsUtil(int index, int sum, int[] array, int[][] dp) {
        if (index == 0) {
            if (sum == 0 && array[0] == 0) {
                return 2;
            }
            if (sum == 0 || sum == array[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int excluded = countPartitionsUtil(index-1, sum, array, dp);
        int included = 0;
        if (array[index] <= sum) {
            included = countPartitionsUtil(index-1, sum - array[index], array, dp);
        }
        return dp[index][sum] = (included + excluded) % mod;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 6, 4};
        int d = 3;
        System.out.println("The number of subsets found are :" + countPartitions(d, array));
        int totalSum = Arrays.stream(array).sum();
        int numOfSubsets = 0;
        numOfSubsets = (totalSum - d) < 0 || (totalSum-d)%2 == 1 ? 0 : tabulation((totalSum-d)/2, array);
        System.out.println("The number of subsets found using Tabulation are: " + numOfSubsets);
    }

    public static int tabulation(int target, int[] array) {
        int n = array.length;
        int[][] dp = new int[n][target+1];

        if (array[0] == 0) {
            dp[0][0] = 2;
        }
        else {
            dp[0][0] = 1;
        }

        if (array[0] != 0 && array[0] <= target){
            dp[0][array[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int t = 0; t <= target; t++) {
                int excluded = dp[index-1][t];
                int included = 0;
                if (array[index] <= t) {
                    included = dp[index-1][t - array[index]];
                }
                dp[index][t] = (included + excluded) % mod;
            }
        }
        return dp[n-1][target];
    }
}
