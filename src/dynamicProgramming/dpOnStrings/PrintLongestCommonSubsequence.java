package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int len = lcsUtil(m-1, n-1, s1, s2, dp);
//        System.out.println(len);
        int i = m;
        int j = n;

        int index = len-1;
        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$";
        }
        StringBuilder ss = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(str);

        while (i > 0 && j > 0) {
            if (ss.charAt(i-1) == s2.charAt(j-1)) {
                str2.setCharAt(index, ss.charAt(i-1));
                index--;
                i--;
                j--;
            }
            else if (ss.charAt(i-1) > s2.charAt(j-1)){
                i--;
            }
            else {
                j--;
            }
        }
        System.out.println(str2);
    }

    private static int lcsUtil(int idx1, int idx2, String s1, String s2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + lcsUtil(idx1-1, idx2-1, s1, s2, dp);
        }
        else {
            return dp[idx1][idx2] = Math.max(lcsUtil(idx1-1, idx2, s1, s2, dp),
                                            lcsUtil(idx1, idx2-1, s1, s2, dp));
        }
    }

    public static void main(String[] args) {
        String s1= "abcde";
        String s2= "bdgek";

        System.out.println("The Longest Common Subsequence is : ");
        lcs(s1, s2);
    }
}
