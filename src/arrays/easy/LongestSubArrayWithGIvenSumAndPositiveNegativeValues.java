package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGIvenSumAndPositiveNegativeValues {
    public static int getLongestSubArray(int[] array, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];

            if (prefixSum == k) {
                maxLength = i + 1;
            }

            if (prefixSumMap.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum -k));
            }
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println("Length of the longest subarray: " + getLongestSubArray(arr, k));
    }
}
