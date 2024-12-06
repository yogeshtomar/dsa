package graphs.topologicalSort;
import java.util.*;

public class AleinDictionaryEducative {
    public static String alienOrder(List<String> words) {
        HashMap<Character, List<Character>> adjList = new HashMap<Character, List<Character>>();
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (String word : words) {
            char[] strArray = word.toCharArray();
            for (char c : strArray) {
                count.put(c, 0);
            }
        }

        Set<Character> characters = count.keySet();

        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);

            int j = 0;
            for (j = 0; j < word1.length() && j < word2.length(); j++) {
                char c = word1.charAt(j);
                char d = word2.charAt(j);

                if (c != d) {
                    if (adjList.get(c) == null) {
                        adjList.put(c, new ArrayList<Character>());
                    }

                    if (adjList.get(d) == null) {
                        adjList.put(d, new ArrayList<Character>());
                    }

                    boolean found = false;
                    for (int k = 0; k < adjList.get(c).size(); k++) {
                        if (adjList.get(c).get(k) == d) {
                            found = true;
                        }
                    }

                    if (!found) {
                        adjList.get(c).add(d);
                        count.put(d, count.get(d) + 1);
                    }

                    break;
                }
            }

            // Check that second word isn't a prefix of first word.
            if (j >= word1.length() || j >= word2.length()) {
                if (word2.length() < word1.length()) {
                    return "";
                }
            }
        }

        // Step 2: We need to repeatedly pick off nodes with an indegree of 0.
        List<Character> result = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();

        for (char c : count.keySet()) {
            if (count.get(c) == 0) {
                queue.add(c);
            }
        }

        int m = 0;
        while (!queue.isEmpty()) {
            m += 1;
            char c = queue.removeFirst();
            result.add(c);
            int n = 0;

            if (adjList.get(c) == null) {
                adjList.put(c, new ArrayList<>());
            }

            for (int f = 0; f < adjList.get(c).size(); f++) {
                char d = adjList.get(c).get(f);
                n += 1;
                count.put(d, count.get(d) - 1);

                if (count.get(d) == 0) {
                    queue.add(d);
                }
            }
        }

        // If not all letters are in result, that means there was a cycle and so
        // no valid ordering. Return "".
        if (result.size() < characters.size()) {
            return "";
        }

        // Otherwise, convert the ordering we found into a string and return it.
        StringBuilder sb = new StringBuilder();

        // Appends characters one by one
        for (Character ch : result) {
            sb.append(ch);
        }

        String output = sb.toString();
        return output;
    }

    public static void main(String args[]) {
        List<List<String>> words = Arrays.asList(
                Arrays.asList("mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv"),
                Arrays.asList("vanilla", "alpine", "algor", "port", "norm", "nylon", "ophellia", "hidden"),
                Arrays.asList("passengers", "to", "the", "unknown"),
                Arrays.asList("alpha", "bravo", "charlie", "delta"),
                Arrays.asList("jupyter", "ascending")
        );

        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + 1 + ".\twords = " + words.get(i));
            alienOrder(words.get(i));
            System.out.println("\tDictionary = \"" + alienOrder(words.get(i)) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
