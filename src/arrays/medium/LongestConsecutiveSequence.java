package arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int item : array) {
            set.add(item);
        }

        int longest = 1;
        for (int item : set) {
            if (!set.contains(item - 1)) {
                int count = 1;
                int x = item;
                while (set.contains(x+1)) {
                    x = x + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] array = {100, 200, 1, 2, 3, 4};
        int ans = longestConsecutiveSequence(array);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
