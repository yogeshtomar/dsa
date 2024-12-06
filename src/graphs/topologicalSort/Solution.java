package graphs.topologicalSort;

import java.util.*;

public class Solution {
    private static List<List<Integer>> adjList = new ArrayList<>();

    public static boolean canFinish(int numCourses, int[][] prerequesites) {
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // build graph from prerequisites
        // [0, 1] -> to take 0 you have to take 1 first
        int[] inDegree = new int[numCourses+1];
        for(int[] dep : prerequesites) {
            int parent = dep[1];
            int child = dep[0];
            addEdge(parent, child);
            inDegree[child]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        // int index = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            // order.add(index++, current);
            order.add(current);
            for(int next : adjList.get(current)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return order.size() == numCourses;
    }

    private static void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    public static void main(String[] args) {
        int[]n = {4, 5, 2, 4, 7};
        int[][][]prerequisites = {
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {2, 0}, {3, 1},{4, 3}},
                {{1, 0}}, {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}};

        int num = 2;
        int[][] pre = {{1, 0}, {0, 1}};

        System.out.println(canFinish(num, pre));

//        for(int i=0; i<n.length; i++){
//            System.out.println(".\tPrerequisites: "+ Arrays.deepToString(prerequisites[i])+"\n\tTotal number of courses, n = "+n[i]);
//            System.out.println("can finish course : " + canFinish(n[i], prerequisites[i]));
//        }
    }
}
