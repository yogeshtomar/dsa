package binarySearch.bsOnAnswers;

public class SplitArrayLargestSum {
    public static int largestSubarraySumMinimized(int[] array, int k) {
        int low = array[0];
        int high = 0;

        for (int i = 0; i < array.length; i++) {
            low = Math.max(low, array[i]);
            high += array[i];
        }

        while (low <= high) {
            int mid = low + (high - low)/2;
            int partitions = countPartitions(array, mid);
            if (partitions > k) {
                low = mid + 1;
            }
             else {
                 high = mid - 1;
            }
        }
        return low;
    }

    private static int countPartitions(int[] array, int maxSum) {
        int n = array.length;
        int partitions = 1;
        long subArraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subArraySum + array[i] <= maxSum) {
                subArraySum += array[i];
            }
            else {
                partitions++;
                subArraySum = array[i];
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}
