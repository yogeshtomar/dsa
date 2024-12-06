package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDAG {
    public static boolean isCyclic(int V, List<List<Integer>> adjList) {
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
        int index = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            topologicalOrder.add(index++, currentNode);
            for (int neigh : adjList.get(currentNode)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        if (topologicalOrder.size() != V) {
            return true;
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 11;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(3).add(7);
        adjList.get(4).add(5);
        adjList.get(5).add(6);
        adjList.get(7).add(5);
        adjList.get(8).add(9);
        adjList.get(9).add(10);
        adjList.get(10).add(8);

        System.out.println("Cycle Detected : " + isCyclic(V, adjList));
    }
}
