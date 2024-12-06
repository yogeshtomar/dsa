package graphs.traversal;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFS {
    public static void main(String[] args) {
        int V = 3;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);

        System.out.println("is Cycle detected : " + detectCycleOnAllVertex(V, adjList));

        int V2 = 5;
        List<List<Integer>> adj2 = new ArrayList<>(V);

        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 3);
        addEdge(adj2, 3, 4);

        System.out.println(detectCycleOnAllVertex(V2, adj2));
    }

    private static void addEdge(List<List<Integer>>adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static boolean detectCycleOnAllVertex(int V,List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adjList, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, int source, boolean[] visited, int parent) {
        visited[source] = true;
        for (int child : adjList.get(source)) {
            if (!visited[child]) {
                if(dfs(adjList, child, visited, source)) {
                    return true;
                }
            }
            else if (child != parent){
                return true;
            }
        }
        return false;
    }
}
