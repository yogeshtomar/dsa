package graphs.topologicalSort;

import java.util.*;

public class CompilationOrder {
    public static List<Character> findCompilationOrder(List<List<Character>> dependencies) {
        List<Character> result = new ArrayList<>();

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(List<Character> edge : dependencies) {
            char parent = edge.get(0);
            char child = edge.get(1);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }

        if (graph.isEmpty()) {
            return result;
        }

        for(List<Character> edge : dependencies) {
            char parent = edge.get(1);
            char child = edge.get(0);
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Character> queue = new LinkedList<>();
        for (char key : graph.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            result.add(vertex);
            for (char child : graph.get(vertex)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (result.size() != graph.size()) {
            System.out.println("Graph contains a loop...");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<List<Character>>> dependencies = new ArrayList<>() {
            {
                add(new ArrayList<>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'E')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'C')));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('A', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('A', 'F')));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('C', 'C')));
                    }
                });
            }
        };
        for (List<List<Character>> dependency : dependencies) {
            System.out.println("Compilation Order : " + findCompilationOrder(dependency));
        }
    }
}
