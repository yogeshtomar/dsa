package binaryHeaps;

import java.util.Arrays;

public class MinToMaxHeapConverter {
    public static void convertMinHeapToMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n-2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] minHeap = {1,3, 5, 7, 9, 8, 10};
        System.out.println("Min Heap Array" + Arrays.toString(minHeap));

        convertMinHeapToMaxHeap(minHeap);

        System.out.println("Converted Max Heap Array");
        System.out.println(Arrays.toString(minHeap));

    }
}
