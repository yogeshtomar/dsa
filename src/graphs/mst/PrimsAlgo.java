package graphs.mst;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class PrimsAlgo {
    public static class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int primsMinimumSpanningTree(int V, List<List<Pair>> adjList) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int wt = cur.distance;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sum += wt;

            for (Pair neigh : adjList.get(node)) {
                int edgeW = neigh.distance;
                int adjNode = neigh.node;

                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, edgeW));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1, 2);
        addEdge(adjList, 0, 2, 1);
        addEdge(adjList, 1, 2, 1);
        addEdge(adjList, 2, 3, 2);
        addEdge(adjList, 3, 4, 1);
        addEdge(adjList, 4, 2, 2);

        int res = primsMinimumSpanningTree(V, adjList);
        System.out.println("Prim's MST : " + res);

    }

    private static void addEdge(List<List<Pair>> adjList, int u, int v, int w) {
        adjList.get(u).add(new Pair(v, w));
        adjList.get(v).add(new Pair(u, w));
    }
}
