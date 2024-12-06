package binaryHeaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public static int kthLargestMaxHeap(int[] array, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int n = array.length;

        for (int i = 0; i < n; i++) {
            pq.add(array[i]);
        }

        int f = k-1;
        while (f > 0) {
            pq.poll();
            f--;
        }

        System.out.println("the " + k + "th largest  element in the array: " + Arrays.toString(array) + " is: " + pq.peek());
        return pq.peek();
    }

    public static int kthSmallestMinHeap(int[] array, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        int n = array.length;

        for (int i : array) {
            pq.add(i);
        }

        int f = k-1;
        while (f > 0) {
            pq.poll();
            f--;
        }
        System.out.println("the " + k + "th smallest  element in the array: " + Arrays.toString(array) + " is: " + pq.peek());
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 5, 3};
        System.out.println(kthLargestMaxHeap(arr, 3));
        System.out.println(kthSmallestMinHeap(arr, 3));
        System.out.println(kthLargestUsingQuickSelect(arr, 3));
    }

    public static int kthLargestUsingQuickSelect(int[] array, int k) {
        int left = 0, right = array.length-1;
        int kth = -1;
        while (true) {
            int idx = partition(array, left, right);
            if (idx == k-1) {
                kth = array[idx];
                break;
            }
            if (idx < k-1) {
                left = idx+1;
            }
            else {
                right = idx-1;
            }
        }
        return kth;
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int l = left+1;
        int r = right;

        while (l <= r) {
            if (array[l] < pivot && array[r] > pivot) {
               swap(array, l, r);
               l++;
               r--;
            }
            if (array[l] >= pivot) {
                l++;
            }
            if (array[r] <= pivot) {
                r--;
            }
        }
        swap(array, left, r);
        return r;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
