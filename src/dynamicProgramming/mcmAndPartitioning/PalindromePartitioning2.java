package dynamicProgramming.mcmAndPartitioning;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */

public class PalindromePartitioning2 {
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutUtil(0, s, dp) - 1;
    }

    private static int minCutUtil(int idx, String s, int[] dp) {
        if (idx == s.length()) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int minCuts = Integer.MAX_VALUE;

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(idx, i, s)) {
                int cuts = 1 + minCutUtil(i+1, s, dp);
                minCuts = Math.min(cuts, minCuts);
            }
        }
        return dp[idx] = minCuts;
    }

    private static boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "abccbc";

        System.out.println("Minimum cuts needed for palindrome partitioning of '" + s1 + "' = " + minCut(s1));
        System.out.println("Minimum cuts needed for palindrome partitioning of '" + s2 + "' = " + minCut(s2));
    }
}
