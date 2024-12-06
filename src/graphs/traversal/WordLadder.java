package graphs.traversal;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String startWord, String endWord, List<String> wordList) {
        if (startWord.equals(endWord)) {
            return 0;
        }

        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                char[] currentWord = queue.poll().toCharArray();
                for (int i = 0; i < currentWord.length; i++) {
                    char tmp = currentWord[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentWord[i] = ch;
                        String dest = new String(currentWord);
                        if (dictionary.contains(dest)) {
                            if (dest.equals(endWord)) {
                                return length+1;
                            }
                            queue.add(dest);
                            dictionary.remove(dest);
                        }
                    }
                    currentWord[i] = tmp;
                }
            }
            length++;

        }

        return 0;
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

        System.out.println(ladderLength(startWord, targetWord, List.of(wordList)));

        String startWord2 = "hit", targetWord2 = "cog";
        String[] wordlist2 = {
                "hot","dot","dog","lot","log","cog"
        };
        System.out.println(ladderLength(startWord2, targetWord2, List.of(wordlist2)));
    }
}
