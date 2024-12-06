package graphs.shortestpathalgos;

import java.util.*;

public class ShortestPathUnitWeightBFS {
    public static int[] shortestPathBFS(int[][] graph, int vertex, int edges, int source) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
            adjList.get(graph[i][1]).add(graph[i][0]);
        }

        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = 1 + dist[node];
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }
        return dist;
    }

    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        int[] res = shortestPathBFS(edge, n, m, 0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

}
