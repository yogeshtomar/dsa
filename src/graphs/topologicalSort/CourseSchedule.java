package graphs.topologicalSort;

import java.util.*;

public class CourseSchedule {
    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inDegree.put(i , 0);
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int parent = pre[1];
            int child = pre[0];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neigh : graph.get(node)) {
                inDegree.put(neigh, inDegree.get(neigh)-1);
                if (inDegree.get(neigh) == 0) {
                    queue.add(neigh);
                }
            }
        }

        if (result.size() != n) {
            System.out.println("Cycle detected in the graph");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        int[]n = {4, 5, 2, 4, 7};
        int[][][]prerequisites = {
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {2, 0}, {3, 1},{4, 3}},
                {{1, 0}}, {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}};
        for(int i=0; i<n.length; i++){
            System.out.print(i+1);
            System.out.println(".\tPrerequisites: "+Arrays.deepToString(prerequisites[i])+"\n\tTotal number of courses, n = "+n[i]);
            List<Integer> result = findOrder(n[i], prerequisites[i]);
            System.out.println("\tValid courses order: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
