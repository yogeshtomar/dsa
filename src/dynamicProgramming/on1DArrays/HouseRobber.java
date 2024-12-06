package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        return Math.max(robWithMemo(houses, 0, houses.length-2), robWithMemo(houses, 1, houses.length-1));
    }
    private static int robWithMemo(int[] houses, int start, int end) {
        int[] dp = new int[houses.length+1];
        Arrays.fill(dp, -1);
        return robHelper(houses, start, end, dp);
    }

    private static int robHelper(int[] houses, int index, int end, int[] dp) {
        if (index > end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int rob = houses[index] + robHelper(houses, index +2, end, dp);
        int skip = robHelper(houses, index+1, end, dp);

        return dp[index] = Math.max(rob, skip);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        System.out.println("Max Rob Amount: " + rob(nums1));

        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Max Rob Amount: " + rob(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println("Max Rob Amount: " + rob(nums3));
    }
}
