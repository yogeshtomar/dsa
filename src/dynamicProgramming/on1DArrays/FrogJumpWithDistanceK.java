package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class FrogJumpWithDistanceK {
    private static int frogJump(int stairs, int[] height, int k) {
        int[] dp = new int[stairs+1];
        Arrays.fill(dp, -1);
        frogJumpHelperWithK(stairs, k, height, dp);
        return dp[stairs];
    }

    private static int frogJumpHelperWithK(int stairs, int k, int[] height, int[] dp) {
        if (stairs == 0) {
            return dp[stairs] = 0;
        }
        if (dp[stairs] != -1) {
            return dp[stairs];
        }

        int minSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (stairs - j >= 0) {
                int jump = frogJumpHelperWithK(stairs - j, k, height, dp)
                            + Math.abs(height[stairs] - height[stairs-j]);
                minSteps = Math.min(jump, minSteps);
            }
        }

        return dp[stairs] = minSteps;
    }

    private static int tabulation(int stairs, int k, int[] height) {
        int[] dp = new int[stairs+1];
        dp[0] = 0;


        for (int i = 1; i < height.length; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i-j]);
                    minSteps = Math.min(jump, minSteps);
                }
            }
            dp[i] = minSteps;
        }

        return dp[stairs];
    }

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println("The min effort to climb the height of " + (n-1) + " stairs is : " +
                frogJump(n-1, height, k));

        System.out.println(tabulation(n-1, k, height));
    }
}
