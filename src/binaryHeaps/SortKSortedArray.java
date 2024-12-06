package binaryHeaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {
    public static void sort(int[] array, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k && i < array.length; i++) {
            pq.add(array[i]);
        }

        int index = 0;
        for (int i = k+1; i < array.length; i++) {
            array[index++] = pq.poll();
            pq.add(array[i]);
        }

        while (!pq.isEmpty()) {
            array[index++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        System.out.println("Original Array: " + Arrays.toString(arr));
        sort(arr, 3);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}
