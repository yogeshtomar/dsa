package dynamicProgramming.onLIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static int longestStringChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 0;

        for (String word : words) {
            int curLength = 1;
            for (int i = 0 ; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i+1);
                curLength = Math.max(curLength, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, curLength);
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println("Longest String Chain Length: " + longestStringChain(words));
    }
}
