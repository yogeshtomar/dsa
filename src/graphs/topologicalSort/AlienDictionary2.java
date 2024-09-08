package graphs.topologicalSort;

import java.util.*;

/*
        b a a           a b c d         a b c a         c a b
        a b c d         a b c a         c a b           c a d

        b -> a          d -> a          a -> c          b -> d

        b d a c
 */

public class AlienDictionary2 {
    public static String findOrder(List<String> words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.put(ch, new ArrayList<>());
                inDegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.size() - 1; i++) {
            String s1 = words.get(i);
            String s2 = words.get(i+1);
            System.out.println("S1 : " + s1 + ", S2 : " + s2);
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    List<Character> neighbours = adj.get(s2.charAt(ptr));
                    if (!neighbours.contains(s2.charAt(ptr))) {
                        System.out.println(s1.charAt(ptr) + " ---> " + s2.charAt(ptr));
                        adj.get(s1.charAt(ptr)).add(s2.charAt(ptr));
                        inDegree.put(s2.charAt(ptr), inDegree.get(s2.charAt(ptr)) + 1);
                        break;
                    }
                }
            }
        }

        System.out.println("InDegree: " + inDegree.toString());
        System.out.println("Graph: " + adj.toString());

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            char ch = entry.getKey();
            int incomingEdges = entry.getValue();
            if (incomingEdges == 0) {
                queue.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char node = queue.poll();
            sb.append(node);

            for (char neighbor : adj.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dict =  new ArrayList<>(Arrays.asList("baa", "abcd", "abca", "cab", "cad"));
        String result = findOrder(dict);
        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i) + " ");
        }
        System.out.print("\n");
    }
}

