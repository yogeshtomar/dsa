package binaryHeaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReplaceElementWithRank {
    public static int[] replaceWithRanks(int[] array) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < array.length; i++){
            pq.add(new int[] {array[i], i});
        }

        int[] ranks = new int[array.length];
        int rank = 1;
        int[] prev = pq.poll();
        ranks[prev[1]] = rank;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[0] != prev[0]) {
                rank++;
            }
            ranks[current[1]] = rank;
            prev = current;
        }
        return ranks;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 40, 30};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        int[] rankedArray = replaceWithRanks(arr);

        System.out.println("Array with ranks:");
        System.out.println(Arrays.toString(rankedArray));
    }
}
