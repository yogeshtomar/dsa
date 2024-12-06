package Strings.easy;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map[ch - 'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("is S: " + s + " and T: " + t + " are anagrams: " + isAnagram(s, t));

        String a = "rat";
        String b = " cat";
        System.out.println("is S: " + a + " and T: " + b + " are anagrams: " + isAnagram(a, b));
    }
}
