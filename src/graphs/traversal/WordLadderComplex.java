package graphs.traversal;
import java.util.*;

public class WordLadderComplex {
    private static final Map<String, Set<String>> adjList = new HashMap<>();
    private static final List<String> currPath = new ArrayList<>();
    private static final List<List<String>> result = new ArrayList<>();

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // copying the words into the set for efficient deletion in BFS
        Set<String> dict = new HashSet<>(wordList);
        // build the DAG using BFS
        bfs(beginWord, endWord, dict);
        if (!adjList.containsKey(endWord)) {
            return result;
        }
        // every path will start from the endWord
        currPath.add(endWord);
        // traverse the DAG to find all the paths between endWord and beginWord
        backtrack(endWord, beginWord);

        return result;
    }

    private static void bfs(String beginWord, String endWord, Set<String> dict) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        // remove the root word which is the first layer in the BFS
        dict.remove(beginWord);

        Set<String> isEnqueued = new HashSet<>();
        isEnqueued.add(beginWord);

        boolean found = false;
        while (!queue.isEmpty()) {
            // visited will store the words of current layer
            Set<String> visited = new HashSet<>();

            for (int i = queue.size() - 1; i >= 0; i--) {
                String currentWord = queue.poll();
                // findNeighbors will have the adjacent words of the currWord
                assert currentWord != null;
                Set<String> neighbors = findNeighbors(currentWord, dict);
                for (String word : neighbors) {
                    if (word.equals(endWord)) {
                        found = true;
                    }
                    visited.add(word);
                    adjList.putIfAbsent(word, new HashSet<>());

                    // add the edge from word to currWord in the list
                    adjList.get(word).add(currentWord);
                    if (isEnqueued.add(word)) {
                        queue.offer(word);
                    }
                }
            }
            if (found) {
                return;
            }
            // removing the words of the previous layer
            for (String word : visited) {
                dict.remove(word);
            }
        }
    }

    private static Set<String> findNeighbors(String word, Set<String> dict) {
        Set<String> neighbors = new HashSet<>();
        char[] charList = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];

            // replace the i-th character with all letters from a to z except the original
            // character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;

                // skip if the character is same as original or if the word is not present in
                // the wordList
                String next = new String(charList);
                if (c == oldChar || !dict.contains(next)) {
                    continue;
                }
                neighbors.add(next);
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }

    private static void backtrack(String source, String destination) {
        // store the path if we reached the endWord
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<String>(currPath);
            Collections.reverse(tempPath);
            result.add(tempPath);
            return;
        }

        if (!adjList.containsKey(source)) {
            return;
        }

        for (String next: adjList.get(source)) {
            currPath.add(next);
            backtrack(next, destination);
            currPath.remove(currPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        List<List<String>> ans = findLadders(startWord, targetWord, List.of(wordList));
        if (ans.isEmpty())
            System.out.println(-1);
        else {

            ans.sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    StringBuilder x = new StringBuilder();
                    StringBuilder y = new StringBuilder();
                    for (String s : o1) {
                        x.append(s);
                    }
                    for (String s : o2) {
                        y.append(s);
                    }
                    return x.toString().compareTo(y.toString());
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
