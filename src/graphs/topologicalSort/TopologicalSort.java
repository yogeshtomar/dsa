package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void addEdge(List<List<Integer>> adjList, int src, int dest) {
        adjList.get(src).add(dest);
    }

    public static List<Integer> topologicalSort(int V, List<List<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, adjList,visited, stack);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void topologicalSortUtil(int vertex, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int child : adjList.get(vertex)) {
            if (!visited[child]) {
                topologicalSortUtil(child, adjList, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 5, 2);
        addEdge(adjList, 5, 0);
        addEdge(adjList, 4, 0);
        addEdge(adjList, 4, 1);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 1);

        System.out.println("Topological Sort : " +topologicalSort(V, adjList));
    }
}
