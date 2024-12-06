package graphs.traversal;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvinces {
    public static int noOfProvinces(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        // Creating adj List from the adj Matrix.
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        // Running DFS from all the vertices ignoring already visited nodes.
        int[] visited = new int [m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (visited[i] != 1) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    private static void dfs(int index, List<List<Integer>> adj, int[] visited) {
        visited[index] = 1;
        for (int i : adj.get(index)) {
            if (visited[i] != 1) {
                dfs(i, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println("No of provinces or Connected components : " + noOfProvinces(graph));
    }
}
