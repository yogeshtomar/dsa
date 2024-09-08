package graphs.topologicalSort;

import java.util.*;

public class AlienDictionary {
    private static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        System.out.println("Indegree : " + Arrays.toString(inDegree));
        System.out.println("Graph: " + adj.toString());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return result;
    }

    public static String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topologicalSort(K, adj);
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + (char) ('a')));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.print("\n");
    }
}
