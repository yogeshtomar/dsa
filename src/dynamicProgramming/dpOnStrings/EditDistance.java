package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

/**
 * We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. The following three operations are allowed:
 * Deletion of a character.
 * Replacement of a character with another one.
 * Insertion of a character.
 * We have to return the minimum number of operations required to convert S1 to S2 as our answer.
 */

public class EditDistance {
    public static int editDistanceUtil(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0) {
            return j+1;
        }
        if (j < 0) {
            return i+1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = editDistanceUtil(i-1, j-1, s1, s2, dp);
        }
        else {
            return  dp[i][j] = 1 + Math.min(editDistanceUtil(i-1, j-1, s1, s2, dp),
                            Math.min(editDistanceUtil(i-1, j, s1, s2, dp),
                                    editDistanceUtil(i, j-1, s1, s2, dp)));
        }
    }

    public static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return editDistanceUtil(m-1, n-1, s1, s2, dp);
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " + editDistance(s1, s2));
    }
}
