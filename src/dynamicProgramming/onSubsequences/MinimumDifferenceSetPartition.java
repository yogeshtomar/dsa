package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class MinimumDifferenceSetPartition {
    public static int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();
        int maxSum = totalSum / 2;

        // 2D memoization array: [selected][currSum]
        int[][] memo = new int[n + 1][totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findMinimumDifference(nums, 0, n, 0, 0, maxSum, totalSum, memo);
    }


    private static int findMinimumDifference(int[] nums, int index, int n, int selected, int currSum, int maxSum, int totalSum, int[][] memo) {
        // Base cases
        if (selected > n || currSum > maxSum) {
            return Integer.MAX_VALUE;
        }
        if (index == nums.length) {
            if (selected == n) {
                int otherSum = totalSum - currSum;
                return Math.abs(otherSum - currSum);
            }
            return Integer.MAX_VALUE;
        }

        if (memo[selected][currSum] != -1) {
            return memo[selected][currSum];
        }

        // Option 1: Include the current element
        int include = findMinimumDifference(nums, index + 1, n, selected + 1, currSum + nums[index], maxSum, totalSum, memo);

        // Option 2: Exclude the current element
        int exclude = findMinimumDifference(nums, index + 1, n, selected, currSum, maxSum, totalSum, memo);

        // Store the result in the memo array
        memo[selected][currSum] = Math.min(include, exclude);
        return memo[selected][currSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Minimum difference between subsets when partitioning the array is : " + minimumDifference(nums));
    }
}
