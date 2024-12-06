package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class KadanesAlgoMaxSubArraySum {
    public static long maxSubArraySum(int[] array) {
        long currentSum = 0;
        long maxSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
    public static List<Integer> printMaxSubArraySum(int[] array) {
        List<Integer> ans = new ArrayList<>();
        int currentSum = 0;
        int maxSum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < array.length; i++) {
            if (currentSum == 0) {
                start = i;
            }
            currentSum += array[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        ans.add(maxSum);
        ans.add(ansStart);
        ans.add(ansEnd);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubArraySum(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);

        List<Integer> ans = printMaxSubArraySum(arr);
        System.out.println("The maximum subarray sum is: " + ans.get(0));
        System.out.println("The maxSumSubArray is : ");
        for (int i = ans.get(1); i <= ans.get(2); i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
