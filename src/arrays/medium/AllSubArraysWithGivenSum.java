package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class AllSubArraysWithGivenSum {
    public static int findAllSubArraysWithGivenSum(int[] array, int k) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;

        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += array[i];

            int remove = preSum - k;

            count += map.getOrDefault(remove, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        System.out.println("The no of subarrays with given sum is : " + findAllSubArraysWithGivenSum(arr, k));
    }
}
