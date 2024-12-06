package graphs.shortestpathalgos;

import java.util.*;

public class DijkstraPriorityQueue {
    public static class Pair {
        int node;
        int wt;
        public Pair(int vertex, int edgeWeight) {
            this.node = vertex;
            this.wt = edgeWeight;
        }
    }
    public static int[] shortestPath(List<List<Pair>> adjList, int nodes, int edges, int source) {
        int[] distance = new int[nodes+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        Queue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.wt - o2.wt;
            }
        });

        priorityQueue.add(new Pair(source, 0));
        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.poll();
            int dis = current.wt;
            int srcNode = current.node;
            for (Pair child : adjList.get(srcNode)) {

                int adjNode = child.node;
                int edgeWt = child.wt;

                if (distance[adjNode] > distance[srcNode] + edgeWt) {
                    distance[adjNode] = dis + edgeWt;
                    priorityQueue.add(new Pair(adjNode, dis + edgeWt));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        List<List<Pair>> adjList = new ArrayList<>();
        int v = 3, e = 3;

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new Pair(1, 1));
        adjList.get(0).add(new Pair(2, 6));
        adjList.get(1).add(new Pair(2, 3));
        adjList.get(1).add(new Pair(0, 1));
        adjList.get(2).add(new Pair(0, 6));
        adjList.get(2).add(new Pair(1, 3));

        int source = 2;

        int[] distance = shortestPath(adjList, v, e, source);

        System.out.println(Arrays.toString(distance));
    }
}
