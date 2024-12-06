package binaryHeaps;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInAStream(int k) {
        this.k = k;
        minHeap = new PriorityQueue<>();
    }

    public int kthLargestInStream(int  num) {
        if (minHeap.size() < k) {
            minHeap.add(num);
        }
        else {
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 4;
        KthLargestElementInAStream sol = new KthLargestElementInAStream(4);
        System.out.println(sol.kthLargestInStream(4));
        System.out.println(sol.kthLargestInStream(5));
        System.out.println(sol.kthLargestInStream(8));
        System.out.println(sol.kthLargestInStream(2));
//        System.out.println(sol.kthLargestInStream(3));
//        System.out.println(sol.kthLargestInStream(1));

    }
}
