package graphs.traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    private static boolean dfs(int v, int[][] grid, int[] color, int cur) {
        if (color[v] != -1) {
            return color[v] == cur;
        }

        color[v] = cur;

        for (int u : grid[v]) {
            boolean res = dfs(u, grid, color, cur^1);
            if (!res) {
                return res;
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return true;
        }

        int n = grid.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        boolean res = true;
        for (int v = 0; v < grid.length; v++) {
            if (color[v] == -1) {
                res = res & dfs(v, grid, color, 0);
                if (!res) {
                    break;
                }
            }
        }

        return res;
    }

    // Function to check if the graph is bipartite
    public static boolean isBipartiteGraph(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: uncolored, 1: color1, -1: color2

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // Not yet colored
                if (!bfsCheck(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1; // Start coloring the first node with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = colors[node];

            for (int neighbor = 0; neighbor < graph.length; neighbor++) {
                if (graph[node][neighbor] == 1) { // There's an edge between node and neighbor
                    if (colors[neighbor] == 0) { // If neighbor is not colored
                        colors[neighbor] = -currentColor; // Color with opposite color
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == currentColor) { // If neighbor has the same color
                        return false; // Not bipartite
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int[][] grid = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println("Is Graph Bipartite : " + isBipartiteGraph(graph));
    }
}
