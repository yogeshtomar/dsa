package binaryHeaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxHeapPriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MaxHeapPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void add(T item) {
        heap.add(item);
        heapifyUp(heap.size()-1);
    }

    public T poll() {
        if (heap.isEmpty()) {
            return null;
        }
        T max = heap.get(0);
        T lastItem = heap.remove(heap.size()-1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            heapifyDOwn(0);
        }
        return max;
    }

    public T peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index -1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            }
            else {
                break;
            }
        }
    }

    private void heapifyDOwn(int index) {
        int leftChild, rightChild, largest;
        while (index < heap.size()) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largest = index;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(largest)) > 0) {
                largest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
                largest = rightChild;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            }
            else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue<Integer> priorityQueue = new MaxHeapPriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(40);
        priorityQueue.add(5);
        priorityQueue.add(20);

        System.out.println("Size: " + priorityQueue.size());
        System.out.println("Max Element: " + priorityQueue.peek());

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
