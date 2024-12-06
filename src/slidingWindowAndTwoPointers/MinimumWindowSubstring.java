package slidingWindowAndTwoPointers;
/*
 * Explanation
 * Initial Setup:
 *      Create a targetMap to store the frequency of each character in t.
 *      Use windowMap to store the frequency of characters within the current window in s.
 * Expand Window:
 *      Expand the window by moving right and adding characters to windowMap.
 *      If a character's frequency in windowMap matches targetMap, increment formed.
 * Shrink Window:
 *      When formed equals required, the current window is valid. Try to move left to reduce the size of the window while maintaining validity.
 *      Update minLength and start when a smaller valid window is found.
 * Output:
 *      If minLength was updated, return the substring; otherwise, return "".
 * Time Complexity: 𝑂(𝑛+𝑚) n is the length of s and m is the length of t
 * Space Complexity:
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
        int required = targetMap.size();
        int formed = 0;

        while (right < s.length()) {
            char rch = s.charAt(right);
            windowMap.put(rch, windowMap.getOrDefault(rch, 0) + 1);

            if (targetMap.containsKey(rch) && windowMap.get(rch).intValue() == targetMap.get(rch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char lch = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                windowMap.put(lch, windowMap.get(lch) - 1);
                if (targetMap.containsKey(lch) && windowMap.get(lch) < targetMap.get(lch)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Minimum window substring: " + minWindow(s, t));
    }
}
