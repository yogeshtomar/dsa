package graphs.shortestpathalgos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int steps;
    public Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
public class MinimumMultiplicationToReachEnd {
    static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));

        int N = 100000;
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        int mod = 100000;
        int n = arr.length;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int node = cur.node;
            int steps = cur.steps;

            for (int i = 0; i < n; i++) {
                int num = (arr[i] * node) % mod;
                if (steps + 1 < distance[num]) {
                    distance[num] = steps + 1;
                    if (num == end) {
                        return steps + 1;
                    }
                    queue.add(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int start = 3, end = 30;
        int[] arr = {2, 5, 7};

        System.out.println(minimumMultiplications(arr, start, end));
    }
}
