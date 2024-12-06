package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class ClimbingStairs {
    public static int climbingStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return climbingStairsHelper(n, dp);
    }

    private static int climbingStairsHelper(int n, int[] dp) {
    if (n == 0 || n == 1) {
        return dp[n] = 1;
    }

    if (dp[n] != -1) {
        return dp[n];
    }

    return dp[n] = climbingStairsHelper(n-1, dp) + climbingStairsHelper(n-2, dp);
}

    public static int tabular(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(STR."The number of ways to climb the \{n} stairs: \{climbingStairs(n)}");
        System.out.println(STR."The number of ways to climb the \{n} stairs: \{tabular(n)}");
    }
}
