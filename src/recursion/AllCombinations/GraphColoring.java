package recursion.AllCombinations;

public class GraphColoring {
    public static boolean graphColoring(int[][] graph, int m, int n) {
        int[] color = new int[n];
        boolean result = false;
        result = backTrack(graph, 0, color, m, n);
        return result;
    }

    private static boolean backTrack(int[][] graph, int node, int[] color, int m, int n) {
        if (node == n) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, node, color, c, n)) {
                color[node] = c;
                if (backTrack(graph, node+1, color, m, n)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] graph, int node, int[] color, int c, int n) {
        // Check all adjacent vertices
        for (int i = 0; i < n; i++) {
            if (graph[node][i] == 1 && color[i] == c) {
                return false;   // Adjacent vertex has the same color
            }
        }
        return true;    // Safe to assign this color
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        int m = 3; // Number of colors
        int n = graph.length; // Number of vertices

        boolean result = graphColoring(graph, m, n);
        if (result) {
            System.out.println("Graph can be colored with " + m + " colors.");
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}
