package dynamicProgramming.mcmAndPartitioning;

import java.util.Arrays;

/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented
 * by an array. You are asked to burst all the balloons.If you burst the ith balloon, you will get
 * arr[i - 1] * arr[i] * arr[i + 1] coins. If i - 1 or i + 1 goes out of the array's bounds, then treat it as
 * if there is a balloon with a 1 painted on it.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */

public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = balloons[n+1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return burst(1, n, balloons, dp);
    }

    private static int burst(int left , int right, int[] balloons, int[][] dp) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int maxCoins = 0;
        for (int i = left; i <= right; i++) {
            int coins = balloons[left-1] * balloons[i] * balloons[right+1];
            coins += burst(left, i-1, balloons, dp);
            coins += burst(i+1, right, balloons, dp);

            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[left][right] = maxCoins;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println("Maximum coins you can collect: " + maxCoins(nums));
    }
}
