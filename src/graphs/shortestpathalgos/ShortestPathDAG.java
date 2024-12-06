package graphs.shortestpathalgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

    static class Pair {
        int node;
        int wt;
        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    public static int[] shortestPath(int V, int E, int[][] matrix) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            int wt = matrix[i][2];

            adjList.get(u).add(new Pair(v, wt));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoDFS(i, adjList, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                Pair pair = adjList.get(node).get(i);
                int v = pair.node;
                int wt = pair.wt;;

                if (dist[v] > dist[node] + wt) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private static void topoDFS(int node, List<List<Pair>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Pair child : adjList.get(node)) {
            if (!visited[child.node]) {
                topoDFS(child.node, adjList, visited, stack);
            }
        }

        stack.add(node);
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int[] res = shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
