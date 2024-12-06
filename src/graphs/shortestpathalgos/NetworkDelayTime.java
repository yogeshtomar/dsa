package graphs.shortestpathalgos;

import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        boolean[] visited = new boolean[N+1];
        Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        priorityQueue.add(new int[] {K, 0});
        int res = 0;

        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (!visited[curNode]) {
                visited[curNode] = true;
                res = curDist;
                N--;
                if (graph.containsKey(curNode)) {
                    for (int nextNode : graph.get(curNode).keySet()) {
                        priorityQueue.add(new int[] {nextNode, curDist + graph.get(curNode).get(nextNode)});
                    }
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public static void main(String[] args) {
        int[][] times = { {2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4, k = 2;

        System.out.println("Total Network Delay Time : " + networkDelayTime(times, n, k));
    }
}
