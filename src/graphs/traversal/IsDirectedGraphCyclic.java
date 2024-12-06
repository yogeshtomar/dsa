package graphs.traversal;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class IsDirectedGraphCyclic {
    public static boolean isCyclic(int V, List<List<Integer>> adjList) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfsCheck(i, adjList, visited, pathVisited) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsCheck(int currentNode, List<List<Integer>> adjList, int[] visited, int[] pathVisited) {
        visited[currentNode] = 1;
        pathVisited[currentNode] = 1;

        for (int child : adjList.get(currentNode)) {
            if (visited[child] == 0) {
                if (dfsCheck(child, adjList, visited, pathVisited)) {
                    return true;
                }
            }
            else if (pathVisited[child] == 1) {
                return true;
            }
        }

        pathVisited[currentNode] = 0;
        return false;
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
