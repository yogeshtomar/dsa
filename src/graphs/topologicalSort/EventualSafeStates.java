package graphs.topologicalSort;

import java.util.*;

public class EventualSafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree =  new int[n];
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                neighbors.get(neighbor).add(i);
                inDegree[i]++;
            }
        }

        Set<Integer> result = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : neighbors.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][][] graph = { {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}, {{1,2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}};
        for (int i = 0; i < graph.length; i++) {
            System.out.println(eventualSafeNodes(graph[i]));
        }


    }
}
