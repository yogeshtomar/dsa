package slidingWindowAndTwoPointers;

//https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] frequency = new int[26];

        while (right < s.length()) {
            char rch = s.charAt(right);
            frequency[rch - 'A']++;
            maxCount = Math.max(maxCount, frequency[rch - 'A']);

            int lettersToChange = (right - left + 1) - maxCount;

            while (lettersToChange > k) {
                char lch = s.charAt(left);
                frequency[lch - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest length after " + k + " replacements: " + sol.characterReplacement(s, k));
    }
}
