package binaryHeaps;

public class CheckMinHeap {
    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < n && arr[leftChild] < arr[i]) {
                return false;
            }

            if (rightChild < n && arr[rightChild] < arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 8, 10};
        if (isMinHeap(arr)) {
            System.out.println("The array is a min-heap");
        } else {
            System.out.println("The array is not a min-heap");
        }
    }
}
