package dynamicProgramming.onLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    private static List<Integer> largestDivisibleSubset(int[] array) {
        int n = array.length;
        Arrays.sort(array);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 0, maxIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] % array[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(array[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println("Largest Divisible Subset: " + largestDivisibleSubset(nums)); // Output: [1, 2, 4, 8]
    }
}
