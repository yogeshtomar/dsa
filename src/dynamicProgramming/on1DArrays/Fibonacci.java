package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class Fibonacci {
    public static int fibonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibonacciHelper(n, dp);
    }

    private static int fibonacciHelper(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacciHelper(n-1, dp) + fibonacciHelper(n-2, dp);
    }

    public static int tabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int fibonacciOptimised(int n) {
        int prev2 = 0;
        int prev = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return current;

    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println( n + "th Fibonacci number is :" + fibonacci(n));
        System.out.println( n + "th Fibonacci number from tabulation :" + tabulation(n));
        System.out.println( n + "th Fibonacci number from optimsed tabulation :" + fibonacciOptimised(n));
    }

}
