package graphs.traversal;

import java.util.*;

public class DetectCycleBFS {
    public static boolean detectCycleOnAllVertex(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        boolean result = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(adjList, i, visited)) {
                result = true;
            }
        }
        return result;
    }

    private static boolean bfs(List<List<Integer>> adjList, int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (visited[vertex]) {
                System.out.println("Vertex : " + vertex);
                return true;
            }

            visited[vertex] = true;
            for (int neigh : adjList.get(vertex)) {
                if (!visited[neigh]) {
                    queue.add(neigh);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 9;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 3);
        addEdge(adjList, 5, 6);
        addEdge(adjList, 7, 8);
        System.out.println("is Cycle detected : " + detectCycleOnAllVertex(V, adjList));
    }

    private static void addEdge(List<List<Integer>>adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
