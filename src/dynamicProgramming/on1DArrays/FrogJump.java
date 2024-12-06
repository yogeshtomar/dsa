package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int stair, int[] height) {
        int[] dp = new int[stair+1];
        Arrays.fill(dp, -1);
        frogJumpHelper(stair, height, dp);
        return dp[stair];
    }

    private static int frogJumpHelper(int stair, int[] height, int[] dp) {
        if (stair == 0) {
            return dp[stair] = 0;
        }

        if (dp[stair] != -1) {
            return dp[stair];
        }

        int jumpOne = frogJumpHelper(stair - 1, height, dp) + Math.abs(height[stair] - height[stair-1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (stair > 1) {
             jumpTwo = frogJumpHelper(stair - 2, height, dp) + Math.abs(height[stair] - height[stair-2]);
        }

        return dp[stair] = Math.min(jumpOne, jumpTwo);
    }

    private static int tabulation(int stairs, int[] height) {
        int[] dp = new int[stairs+1];
        dp[0] = 0;
        int jumpTwo = Integer.MAX_VALUE;
        for (int i = 1; i < height.length; i++) {
            int jumpOne = dp[i-1] + Math.abs(height[i] - height[i-1]);
            if (i > 1) {
                jumpTwo = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[stairs];
    }

    private static int spaceOptimised(int stairs, int[] height) {
        int prev = 0;
        int prev2 = 0;
        int n = height.length;

        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev + Math.abs(height[i] - height[i-1]);
            if (i > 1) {
                jumpTwo = prev2 + Math.abs(height[i] - height[i-2]);
            }
            int cur = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        System.out.println("The min effort to climb the height of " + (n-1) + " stairs is : " +
                frogJump(n-1, height));
        System.out.println("The min effort to climb the height using tabulation of " + (n-1) + " stairs is : " +
                tabulation(n-1, height));
        System.out.println("The min effort to climb the height using space optimisation of " + (n-1) + " stairs is : " +
                spaceOptimised(n-1, height));
    }
}
