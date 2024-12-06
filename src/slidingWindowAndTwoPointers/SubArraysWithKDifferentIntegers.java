package slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {
    public static int subarraysWithkDistinct(int[] array, int k) {
        return subarraysWithKDistinctHelper(array, k) - subarraysWithKDistinctHelper(array, k-1);
    }
    public static int subarraysWithKDistinctHelper(int[] array, int K) {
        int count = 0;
        int left = 0, right = 0;
        int n = array.length;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while (right < n) {
            int rightNum = array[right];
            freqMap.put(rightNum, freqMap.getOrDefault(rightNum, 0) + 1);
            while (freqMap.size() > K) {
                int leftNum = array[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println("Number of subarrays with exactly " + k + " different integers: " + subarraysWithkDistinct(nums, k));
    }
}
