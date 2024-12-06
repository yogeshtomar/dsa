package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahnAlgorithm {
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adjList) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neigh : adjList.get(i)) {
                inDegree[neigh]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topologicalOrder = new ArrayList<>();
        int i = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            topologicalOrder.add(i++, currentNode);
            for (int neigh : adjList.get(currentNode)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }
        return topologicalOrder;
    }

    public static void addEdge(List<List<Integer>> adjList, int src, int dest) {
        adjList.get(src).add(dest);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 1);
        addEdge(adjList, 4, 0);
        addEdge(adjList, 4, 1);
        addEdge(adjList, 5, 0);
        addEdge(adjList, 5, 2);

        System.out.println("Topological Sort : " +topologicalSort(V, adjList));
    }
}
