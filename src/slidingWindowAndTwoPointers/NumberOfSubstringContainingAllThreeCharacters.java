package slidingWindowAndTwoPointers;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int left = 0, right = 0;
        int [] count = new int[3];
        int result = 0;

        while (right < s.length()) {
            char rch = s.charAt(right);
            count[rch - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result = result + s.length() - right;
                char lch = s.charAt(left);
                count[lch - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("Number of substrings containing all 3 characters: " + numberOfSubstrings(s));
    }
}
