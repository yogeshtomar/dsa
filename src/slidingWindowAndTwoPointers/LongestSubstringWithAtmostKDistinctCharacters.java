package slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LongestSubstringWithAtmostKDistinctCharacters {
    public static int longestSubstring(String string, int k) {
        if (k == 0 || string.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        int left = 0, right = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while (right < string.length()) {
            char rch = string.charAt(right);
            freqMap.put(rch, freqMap.getOrDefault(rch, 0) + 1);

            while (freqMap.size() > k) {
                char lch = string.charAt(left);
                freqMap.put(lch, freqMap.get(lch) - 1);
                if (freqMap.get(lch) == 0) {
                    freqMap.remove(lch);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right -left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Length of longest substring with at most " + k + " distinct characters: " + longestSubstring(s, k));
    }
}
