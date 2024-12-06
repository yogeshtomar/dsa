package graphs.shortestpathalgos;

import java.util.Arrays;
import java.util.Map;

public class CityWithSmallestNoOfNeighborsAtAThresholdDistance {
    private static void floydWarshall(int[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, (int)1e4+1);
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            dist[src][dest] = wt;
            dist[dest][src] = wt;
        }

        floydWarshall(dist, n);
        int result = -1;
        int minCity = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCity) {
                minCity = count;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges =  {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}
