package graphs.shortestpathalgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgo {
    static int[] bellmanFord(int V, List<List<Integer>> adjList, int source) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int i = 0; i < V-1; i++) {
            for (List<Integer> edge : adjList) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }

            for (List<Integer> edge : adjList) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    int[] temp = new int[1];
                    temp[0] = -1;
                    System.out.println("The Graph contains Negative Weight Cycle");
                    return temp;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        List<List<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };



        int[] dist = bellmanFord(V, edges, S);
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
