package graphs.topologicalSort;

import java.util.*;

public class CourseSchedule2 {
    private static void addEdge(List<List<Integer>> adjList, int parent, int child) {
        adjList.get(parent).add(child);
    }
    public  static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return null;
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];
            addEdge(adjList, dependency, course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int next : adjList.get(course)){
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return order;
    }

    public static int[] findOrder2(int num, int[][] prerequisites) {
        if (num <= 0) return null;

        int[] inDegree = new int[num];
        int[] order = new int[num];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int dependentOn = prerequisites[i][1];
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index= 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == course) {
                    int dependentCourse = prerequisites[i][0];
                    inDegree[dependentCourse]--;
                    if (inDegree[dependentCourse] == 0) {
                        queue.add(dependentCourse);
                    }
                }
            }
        }

        return order;
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
            int[] result = findOrder2(n[i], prerequisites[i]);
            System.out.println("\tValid courses order: " + Arrays.toString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
