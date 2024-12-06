package Strings.medium;

public class LongestPalindromicSubstring {
    // without dp
    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j) && isPalindrome(s, i+1, j-1)) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return  res;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        if (right - left <= 2) return true;
        return isPalindrome(s, left + 1, right-1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("S: " + s + " longest Palindromic Subsequence : " + longestPalindrome(s));
    }
}
