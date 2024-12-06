package graphs.traversal;

import java.util.*;

public class WordLadder2 {
    private static List<List<String>> res = new ArrayList<>();
    private static List<String> list = new ArrayList<>();
    private static Map<String, List<String>> map = new HashMap<>();

    public static List<List<String>> findWordLadders(String startWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty()) {
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>();

        queue.add(startWord);
        unvisited.remove(startWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                String currentWord = queue.poll();
                for (int i = 0; i < currentWord.length(); i++) {
                    char[] currentWordChs = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentWordChs[i] = ch;
                        String newString = new String(currentWordChs);
                        if (unvisited.contains(newString)) {
                            if (!visited.contains(newString)) {
                                visited.add(newString);
                                queue.add(newString);
                            }
                            if (map.containsKey(newString)) {
                                map.get(newString).add(currentWord);
                            } else {
                                List<String> ls = new ArrayList<>();
                                ls.add(currentWord);
                                map.put(newString, ls);
                            }
                        }
                        if (newString.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (found) {
                break;
            }
            unvisited.removeAll(visited);
            visited.clear();
        }
        backTrack(endWord, startWord);
        return res;
    }

    private static void backTrack(String currentWord, String startWord) {
        if (currentWord.equals(startWord)) {
            list.add(0, startWord);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, currentWord);
        if (map.containsKey(currentWord)) {
            for (String str: map.get(currentWord)) {
                backTrack(str, startWord);
            }
        }
        list.remove(0);
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

        List<List<String>> ans = findWordLadders(startWord, targetWord, List.of(wordList));
        if (ans.size() == 0)
            System.out.println(-1);
        else {

            Collections.sort(ans, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    String x = "";
                    String y = "";
                    for (int i = 0; i< o1.size(); i++) {
                        x += o1.get(i);
                    }
                    for (int i = 0; i < o2.size(); i++) {
                        y += o2.get(i);
                    }
                    return  x.compareTo(y);
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
